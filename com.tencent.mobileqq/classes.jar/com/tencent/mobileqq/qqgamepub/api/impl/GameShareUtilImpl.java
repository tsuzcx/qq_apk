package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.gamecenter.share.GameShareConfBean;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor;
import com.tencent.mobileqq.gamecenter.share.GameShareNetHelper;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil.GameShareGalleryData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class GameShareUtilImpl
  implements IGameShareUtil
{
  private static final long MIN_CLICK_INTERVAL = 1000L;
  private static final String TAG = "QQGamePub_GameShare.Util";
  private static long sLastClickTime;
  private static View.OnClickListener sUrlListener = new GameShareUtilImpl.2();
  int DP_SOURCE_RIGHT_MARGIN_DEFAULT = 10;
  
  private boolean isFromGameShare(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForImageShare)) {
      return isGameShare(paramAbsStructMsg);
    }
    return false;
  }
  
  private static boolean isPicInAIOSizeOk(StructMsgForImageShare paramStructMsgForImageShare)
  {
    return paramStructMsgForImageShare.width >= paramStructMsgForImageShare.height;
  }
  
  public static void reportSourceShowInGallery(String paramString, int paramInt, Object paramObject)
  {
    Object localObject = (Integer)IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE.get(paramObject);
    if ((localObject == null) || (((Integer)localObject).intValue() != paramInt))
    {
      localObject = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ((Map)localObject).put(Integer.valueOf(2), localStringBuilder.toString());
      ((Map)localObject).put(Integer.valueOf(4), "8");
      GameCenterUtils.a(null, "870", "206673", paramString, "87007", "1", "145", (Map)localObject);
      IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE.put(paramObject, Integer.valueOf(paramInt));
    }
  }
  
  public void convertDataForGallery(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      try
      {
        StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramObject2;
        if (paramObject1 != null)
        {
          if (localStructMsgForImageShare == null) {
            return;
          }
          String str = getValueFromMsg("game_source_pic_txt", "", localStructMsgForImageShare.message);
          paramObject2 = getValueFromMsg("game_source_pic_url", "", localStructMsgForImageShare.message);
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramObject2)))
          {
            bool = true;
            if (!bool)
            {
              str = "有新动态";
              paramObject2 = new StringBuilder();
              paramObject2.append("https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87007&appid=");
              paramObject2.append(localStructMsgForImageShare.mSourceAppid);
              paramObject2 = paramObject2.toString();
            }
            setPicDataToImageData(paramObject1, localStructMsgForImageShare, str, paramObject2, getIntFromMsg("game_source_type_pic", 0, localStructMsgForImageShare.message), getIntFromMsg("game_source_subtype_pic", 0, localStructMsgForImageShare.message), bool);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramObject1)
      {
        QLog.e("QQGamePub_GameShare.Util", 1, paramObject1, new Object[0]);
        return;
      }
      boolean bool = false;
    }
  }
  
  public IGameShareUtil.GameShareGalleryData getGalleryData(Object paramObject)
  {
    try
    {
      paramObject = (StructMsgForImageShare)paramObject;
      if (paramObject != null)
      {
        if (TextUtils.isEmpty(paramObject.mMsgActionData)) {
          return null;
        }
        paramObject = new JSONObject(paramObject.mMsgActionData);
        IGameShareUtil.GameShareGalleryData localGameShareGalleryData = new IGameShareUtil.GameShareGalleryData();
        localGameShareGalleryData.a = paramObject.optString("game_source_pic_txt");
        localGameShareGalleryData.b = paramObject.optString("game_source_pic_url");
        localGameShareGalleryData.c = paramObject.optInt("game_source_type_pic", 0);
        localGameShareGalleryData.d = paramObject.optInt("game_source_subtype_pic", 0);
        localGameShareGalleryData.e = paramObject.optBoolean("game_source_pic_has_data");
        return localGameShareGalleryData;
      }
      return null;
    }
    catch (Throwable paramObject)
    {
      QLog.e("QQGamePub_GameShare.Util", 1, paramObject, new Object[0]);
    }
    return null;
  }
  
  public int getIntFromMsg(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = getValueFromMsg(paramString, "", paramMessageRecord);
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
  }
  
  public TextView getSourceInGallery(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    paramRelativeLayout.addView(localLinearLayout);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    paramRelativeLayout.width = -1;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(12, -1);
    paramRelativeLayout.addRule(0, 2131442311);
    paramRelativeLayout.rightMargin = AIOUtils.b(20.0F, localResources);
    paramContext = new TextView(paramContext);
    localLinearLayout.addView(paramContext);
    paramRelativeLayout = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    int i = AIOUtils.b(16.0F, localResources);
    paramRelativeLayout.bottomMargin = i;
    paramRelativeLayout.leftMargin = i;
    paramRelativeLayout.height = AIOUtils.b(28.0F, localResources);
    paramContext.setBackgroundResource(2130845837);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 12.0F);
    paramContext.setGravity(16);
    paramContext.setSingleLine(true);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    return paramContext;
  }
  
  public String getValueFromMsg(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramString1 = paramMessageRecord.getExtInfoFromExtStr(paramString1);
      if (TextUtils.isEmpty(paramString1)) {
        return paramString2;
      }
      return paramString1;
    }
    return paramString2;
  }
  
  public void handleBubbleViewForGameShare(int paramInt, Object paramObject, MessageRecord paramMessageRecord)
  {
    if (((paramObject instanceof SessionInfo)) && (paramMessageRecord != null))
    {
      SessionInfo localSessionInfo = (SessionInfo)paramObject;
      if ((localSessionInfo.a != 0) && (localSessionInfo.a != 1)) {
        return;
      }
      Object localObject1 = null;
      int i = -1;
      Object localObject3 = "";
      Object localObject4;
      Object localObject2;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        localObject4 = (MessageForStructing)paramMessageRecord;
        localObject2 = localObject3;
        if ((((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg))
        {
          localObject2 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
          localObject1 = String.valueOf(((AbsShareMsg)localObject2).mSourceAppid);
          if (((AbsShareMsg)localObject2).mMsgServiceID == 5)
          {
            i = 2;
            localObject2 = localObject3;
          }
          else
          {
            localObject2 = ((AbsShareMsg)localObject2).mContentTitle;
            i = 0;
          }
        }
      }
      else if ((paramMessageRecord instanceof MessageForArkApp))
      {
        localObject1 = (MessageForArkApp)paramMessageRecord;
        localObject2 = ((MessageForArkApp)localObject1).ark_app_message.getAppIdFromMeta();
        if ("com.tencent.structmsg".equals(((MessageForArkApp)localObject1).ark_app_message.appName))
        {
          try
          {
            localObject4 = new JSONObject(((MessageForArkApp)localObject1).ark_app_message.metaList).optJSONObject("news");
            localObject1 = localObject3;
            if (localObject4 != null) {
              localObject1 = ((JSONObject)localObject4).optString("title");
            }
          }
          catch (Throwable localThrowable)
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.e("QQGamePub_GameShare.Util", 2, "handleBubbleViewForGameShare", localThrowable);
              localObject1 = localObject3;
            }
          }
          localObject3 = localObject1;
          i = 0;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          localObject3 = ((MessageForArkApp)localObject1).ark_app_message.appName;
          localObject1 = localObject2;
          localObject2 = localObject3;
          i = 1;
        }
      }
      else
      {
        localObject1 = null;
        localObject2 = "";
        i = -1;
      }
      localObject3 = paramMessageRecord.getExtInfoFromExtStr("key_open_game_tag_name");
      String str = paramMessageRecord.getExtInfoFromExtStr("key_open_game_message_ext");
      if ((isWhiteByAppid((String)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        if (paramInt == 0)
        {
          if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("game_source_report_status"))) {
            return;
          }
          paramMessageRecord.saveExtInfoToExtStr("game_source_report_status", "1");
        }
        int j;
        if (localSessionInfo.a == 0) {
          j = 1;
        } else {
          j = 0;
        }
        ((IQQGameCommApi)QRoute.api(IQQGameCommApi.class)).reportGameShare(paramInt, i, j, (String)localObject1, (String)localObject3, str, (String)localObject2);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("handleBubbleViewForGameShare appid=");
        paramMessageRecord.append((String)localObject1);
        paramMessageRecord.append(",tagName=");
        paramMessageRecord.append((String)localObject3);
        paramMessageRecord.append(",sessionInfo=");
        paramMessageRecord.append(paramObject);
        QLog.d("QQGamePub_GameShare.Util", 1, paramMessageRecord.toString());
      }
      return;
    }
  }
  
  public boolean isGameShare(Object paramObject)
  {
    if ((paramObject instanceof AbsShareMsg)) {
      return isWhiteByAppid(String.valueOf(((AbsShareMsg)paramObject).mSourceAppid));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isGameShare msg instance of ");
    localStringBuilder.append(paramObject);
    QLog.w("QQGamePub_GameShare.Util", 1, localStringBuilder.toString());
    return false;
  }
  
  public boolean isWhiteByAppid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      GameShareConfBean localGameShareConfBean = GameShareConfProcessor.a();
      if (localGameShareConfBean != null)
      {
        boolean bool = localGameShareConfBean.b(paramString);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePub_GameShare.Util", 1, paramString, new Object[0]);
      }
    }
    return false;
  }
  
  public void releaseCache()
  {
    S_MSG_TO_REPORT_SUB_TYPE.clear();
  }
  
  public void saveGalleryDataToMsg(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveGalleryDataToMsg params=");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("QQGamePub_GameShare.Util", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQGamePub_GameShare.Util", 1, "saveGalleryDataToMsg params is null");
      }
      return;
    }
    try
    {
      localObject = paramBundle.getString("game_source_pic_txt");
      String str = paramBundle.getString("game_source_pic_url");
      int i = paramBundle.getInt("game_source_type_pic", 0);
      int j = paramBundle.getInt("game_source_subtype_pic", 0);
      long l = paramBundle.getLong("uniseq");
      int k = paramBundle.getInt("is_troop");
      paramBundle = paramBundle.getString("friend_uin");
      try
      {
        paramBundle = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(paramBundle, k, l);
        if (paramBundle == null) {
          return;
        }
        saveValueToMsg("game_source_pic_txt", (String)localObject, paramBundle);
        saveValueToMsg("game_source_pic_url", str, paramBundle);
        saveValueToMsg("game_source_type_pic", String.valueOf(i), paramBundle);
        saveValueToMsg("game_source_subtype_pic", String.valueOf(j), paramBundle);
        ThreadManager.excute(new GameShareUtilImpl.1(this, paramAppRuntime, paramBundle), 32, null, false);
        return;
      }
      catch (Throwable paramAppRuntime) {}
      paramAppRuntime.printStackTrace();
    }
    catch (Throwable paramAppRuntime) {}
    if (QLog.isColorLevel()) {
      QLog.e("QQGamePub_GameShare.Util", 1, "saveGalleryDataToMsg exception", paramAppRuntime);
    }
  }
  
  public void saveValueToMsg(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString2))) {
      paramMessageRecord.saveExtInfoToExtStr(paramString1, paramString2);
    }
  }
  
  public void setPicDataToImageData(Object paramObject1, Object paramObject2, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramObject1 instanceof AIOImageData))
    {
      if (!(paramObject2 instanceof StructMsgForImageShare)) {
        return;
      }
      paramObject1 = (AIOImageData)paramObject1;
      paramObject2 = (StructMsgForImageShare)paramObject2;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("game_source_pic_txt", paramString1);
        localJSONObject.put("game_source_pic_url", paramString2);
        localJSONObject.put("game_source_type_pic", paramInt1);
        localJSONObject.put("game_source_subtype_pic", paramInt2);
        localJSONObject.put("game_source_pic_has_data", paramBoolean);
        paramObject2.mMsgActionData = localJSONObject.toString();
      }
      catch (Throwable paramString1)
      {
        QLog.e("QQGamePub_GameShare.Util", 1, paramString1, new Object[0]);
      }
      paramObject1.s = paramObject2.getBytes();
    }
  }
  
  public void tryAdjustThumbSize(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    try
    {
      paramObject1 = (StructMsgForImageShare)paramObject1;
      MessageForPic localMessageForPic = (MessageForPic)paramObject2;
      paramObject2 = (StructMsgItemImage)paramObject3;
      if ((isFromGameShare(paramObject1)) && (isPicInAIOSizeOk(paramObject1)) && (paramObject2 != null))
      {
        if (localMessageForPic == null) {
          paramObject1 = null;
        } else {
          paramObject1 = localMessageForPic.thumbWidthHeightDP;
        }
        if (paramObject1 != null)
        {
          paramObject1.mMinWidth = 251;
          paramObject1.mMaxWidth = Math.max(paramObject1.mMinWidth, paramObject1.mMaxWidth);
          paramObject1.mMaxHeight = Math.max(paramObject1.mMaxHeight, paramObject1.mMinWidth);
          paramObject2.az = Math.max(paramObject1.mMaxWidth, paramObject2.az);
          paramObject2.aA = Math.max(paramObject1.mMaxHeight, paramObject2.aA);
          return;
        }
      }
    }
    catch (Throwable paramObject1)
    {
      QLog.e("QQGamePub_GameShare.Util", 1, paramObject1, new Object[0]);
    }
  }
  
  public void tryCompactMaxWidth(Object paramObject1, ImageView paramImageView, Object paramObject2)
  {
    try
    {
      paramObject1 = (StructMsgForImageShare)paramObject1;
      paramObject2 = (StructMsgItemImage)paramObject2;
      if ((isFromGameShare(paramObject1)) && (isPicInAIOSizeOk(paramObject1)) && (paramImageView != null) && (paramObject2 != null))
      {
        int i = AIOUtils.b(paramObject2.az, paramImageView.getContext().getResources());
        int j = AIOUtils.b(paramObject2.aA, paramImageView.getContext().getResources());
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (i > paramImageView.getMaxWidth()) {
            paramImageView.setMaxWidth(i);
          }
          if (j > paramImageView.getMaxHeight()) {
            paramImageView.setMaxHeight(j);
          }
        }
        else
        {
          paramImageView.setMaxWidth(i);
          paramImageView.setMaxHeight(j);
          return;
        }
      }
    }
    catch (Throwable paramObject1)
    {
      QLog.e("QQGamePub_GameShare.Util", 1, paramObject1, new Object[0]);
    }
  }
  
  public void tryHandleAioSource(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean, Resources paramResources, Context paramContext, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramObject = (AbsStructMsg)paramObject;
        if (!isFromGameShare(paramObject)) {
          return;
        }
        StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramObject;
        if (!isPicInAIOSizeOk(localStructMsgForImageShare)) {
          return;
        }
        if ((paramView != null) && (paramRelativeLayout != null) && (paramResources != null) && (paramContext != null))
        {
          if (paramObject.message == null) {
            return;
          }
          if (!(paramView instanceof TextView)) {
            break label841;
          }
          paramView = (TextView)paramView;
          paramView.setBackgroundDrawable(null);
          Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramRelativeLayout.setBackgroundResource(2130843656);
          localObject = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
          if (paramBoolean)
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131430578);
            ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(this.DP_SOURCE_RIGHT_MARGIN_DEFAULT, paramResources);
          }
          else
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
            ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131430578);
            ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430587);
            ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(this.DP_SOURCE_RIGHT_MARGIN_DEFAULT, paramResources);
          }
          paramRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = new TextView(paramContext);
          paramContext = new RelativeLayout.LayoutParams(-1, -2);
          paramContext.addRule(6, 2131446457);
          paramContext.addRule(1, 2131446457);
          paramContext.addRule(11, -1);
          paramContext.addRule(8, 2131446457);
          paramContext.addRule(15, -1);
          paramContext.rightMargin = AIOUtils.b(8.0F, paramResources);
          paramRelativeLayout.addView((View)localObject, paramContext);
          ((TextView)localObject).setGravity(21);
          ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject).setSingleLine(true);
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setTextSize(2, 12.0F);
          ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(5.0F, paramResources));
          paramRelativeLayout = paramResources.getDrawable(2130850471);
          paramRelativeLayout.setBounds(0, 0, AIOUtils.b(6.0F, paramResources), AIOUtils.b(10.0F, paramResources));
          ((TextView)localObject).setCompoundDrawables(null, null, paramRelativeLayout, null);
          paramResources = getValueFromMsg("game_source_aio_txt", "", paramObject.message);
          paramRelativeLayout = paramResources;
          if (TextUtils.isEmpty(paramResources))
          {
            GameShareNetHelper.a().a(localStructMsgForImageShare.mSourceAppid, localStructMsgForImageShare.message);
            paramRelativeLayout = "有新动态";
          }
          paramContext = getValueFromMsg("game_source_aio_url", "", paramObject.message);
          paramResources = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            paramResources = new StringBuilder();
            paramResources.append("https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87006&appid=");
            paramResources.append(localStructMsgForImageShare.mSourceAppid);
            paramResources = paramResources.toString();
          }
          int i = getIntFromMsg("game_source_type_aio", 0, paramObject.message);
          int j = getIntFromMsg("game_source_subtype_aio", 0, paramObject.message);
          paramContext = new StringBuilder();
          paramContext.append(localStructMsgForImageShare.mSourceAppid);
          paramContext.append("");
          paramContext = paramContext.toString();
          if (paramView != null)
          {
            paramView.setTag(-1, paramResources);
            paramView.setTag(-5, Integer.valueOf(0));
            paramView.setOnClickListener(sUrlListener);
            ((IQWalletApi)QRoute.api(IQWalletApi.class)).setAlphaChangeListener(paramView, 0.5F);
          }
          ((TextView)localObject).setText(paramRelativeLayout);
          ((TextView)localObject).setTag(-1, paramResources);
          ((TextView)localObject).setTag(-2, Integer.valueOf(i));
          ((TextView)localObject).setTag(-3, Integer.valueOf(j));
          ((TextView)localObject).setTag(-4, paramContext);
          ((TextView)localObject).setTag(-5, Integer.valueOf(1));
          ((TextView)localObject).setOnClickListener(sUrlListener);
          ((IQWalletApi)QRoute.api(IQWalletApi.class)).setAlphaChangeListener((View)localObject, 0.5F);
          paramView = (Integer)IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE.get(Long.valueOf(paramObject.message.uniseq));
          if ((paramView == null) || (paramView.intValue() != j))
          {
            paramView = new HashMap();
            paramRelativeLayout = new StringBuilder();
            paramRelativeLayout.append(j);
            paramRelativeLayout.append("");
            paramView.put(Integer.valueOf(2), paramRelativeLayout.toString());
            paramView.put(Integer.valueOf(4), "8");
            GameCenterUtils.a(null, "870", "206672", paramContext, "87006", "1", "145", paramView);
            IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE.put(Long.valueOf(paramObject.message.uniseq), Integer.valueOf(j));
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGamePub_GameShare.Util", 1, paramView, new Object[0]);
        }
      }
      return;
      label841:
      paramView = null;
    }
  }
  
  public void updateSourceInGallery(TextView paramTextView, Context paramContext, Object paramObject1, Object paramObject2)
  {
    try
    {
      paramObject1 = (AIOImageData)paramObject1;
      Object localObject1 = (AIOGallerySceneWithBusiness)paramObject2;
      if ((paramTextView != null) && (paramContext != null))
      {
        if (paramObject1 == null) {
          return;
        }
        paramObject2 = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramObject1.s);
        IGameShareUtil.GameShareGalleryData localGameShareGalleryData = getGalleryData(paramObject2);
        if ((localGameShareGalleryData != null) && (!TextUtils.isEmpty(localGameShareGalleryData.a)) && (!TextUtils.isEmpty(localGameShareGalleryData.b)))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramObject2.mSourceAppid);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          paramTextView.setVisibility(0);
          paramTextView.setText(localGameShareGalleryData.a);
          paramTextView.setTag(-1, localGameShareGalleryData.b);
          paramTextView.setTag(-4, localObject2);
          paramTextView.setTag(-2, Integer.valueOf(localGameShareGalleryData.c));
          paramTextView.setTag(-3, Integer.valueOf(localGameShareGalleryData.d));
          paramTextView.setTag(-5, Integer.valueOf(2));
          reportSourceShowInGallery((String)localObject2, localGameShareGalleryData.d, paramObject1);
          paramTextView.setOnClickListener(sUrlListener);
          ((IQWalletApi)QRoute.api(IQWalletApi.class)).setAlphaChangeListener(paramTextView, 0.5F);
          localObject2 = paramObject2.mSourceIcon;
          Object localObject3 = paramContext.getResources();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            Object localObject4 = ((Resources)localObject3).getDrawable(2130852668);
            ((Drawable)localObject4).setBounds(0, 0, AIOUtils.b(20.0F, (Resources)localObject3), AIOUtils.b(20.0F, (Resources)localObject3));
            Object localObject5 = new BitmapDrawable(StructMsgItemCover.a((Drawable)localObject4));
            paramTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, (Resources)localObject3));
            ((Drawable)localObject5).setBounds(0, 0, AIOUtils.b(20.0F, (Resources)localObject3), AIOUtils.b(20.0F, (Resources)localObject3));
            paramTextView.setCompoundDrawables((Drawable)localObject5, null, null, null);
            localObject5 = ((Resources)localObject3).getDrawable(2130852669);
            ((Drawable)localObject5).setBounds(0, 0, AIOUtils.b(20.0F, (Resources)localObject3), AIOUtils.b(20.0F, (Resources)localObject3));
            localObject2 = URLDrawable.getDrawable((String)localObject2, (Drawable)localObject4, (Drawable)localObject5);
            localObject3 = new WeakReference(paramContext);
            localObject4 = new WeakReference(paramTextView);
            localObject1 = new WeakReference(localObject1);
            long l1 = paramObject1.L;
            long l2 = paramObject1.M;
            ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).decodeDrawable((Drawable)localObject2, new GameShareUtilImpl.3(this, (WeakReference)localObject3, (WeakReference)localObject4, (WeakReference)localObject1, l1, l2));
            if (!localGameShareGalleryData.e) {
              GameShareNetHelper.a().a(paramObject2.mSourceAppid, new GameShareUtilImpl.4(this, (WeakReference)localObject3, (WeakReference)localObject4, (WeakReference)localObject1, l1, l2, paramObject1));
            }
          }
        }
        else
        {
          paramTextView.setCompoundDrawables(null, null, null, null);
        }
        paramContext = paramContext.getResources();
        paramTextView.setPadding(AIOUtils.b(5.0F, paramContext), 0, AIOUtils.b(14.0F, paramContext), 0);
        return;
      }
      return;
    }
    catch (Throwable paramTextView)
    {
      QLog.e("QQGamePub_GameShare.Util", 1, paramTextView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl
 * JD-Core Version:    0.7.0.1
 */