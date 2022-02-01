package com.tencent.mobileqq.gamecenter.share;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletPicHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class GameShareUtil
{
  private static long jdField_a_of_type_Long = 0L;
  private static View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GameShareUtil.1();
  private static Map<Object, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    paramString = a(paramString, "", paramMessageRecord);
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
  
  public static TextView a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    paramRelativeLayout.addView(localLinearLayout);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    paramRelativeLayout.width = -1;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(12, -1);
    paramRelativeLayout.addRule(0, 2131374678);
    paramRelativeLayout.rightMargin = AIOUtils.a(20.0F, localResources);
    paramContext = new TextView(paramContext);
    localLinearLayout.addView(paramContext);
    paramRelativeLayout = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    int i = AIOUtils.a(16.0F, localResources);
    paramRelativeLayout.bottomMargin = i;
    paramRelativeLayout.leftMargin = i;
    paramRelativeLayout.height = AIOUtils.a(28.0F, localResources);
    paramContext.setBackgroundResource(2130844558);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 12.0F);
    paramContext.setGravity(16);
    paramContext.setSingleLine(true);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    return paramContext;
  }
  
  public static GameShareUtil.GameShareGalleryData a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if ((paramStructMsgForImageShare == null) || (TextUtils.isEmpty(paramStructMsgForImageShare.mMsgActionData))) {
      return null;
    }
    try
    {
      paramStructMsgForImageShare = new JSONObject(paramStructMsgForImageShare.mMsgActionData);
      GameShareUtil.GameShareGalleryData localGameShareGalleryData = new GameShareUtil.GameShareGalleryData();
      localGameShareGalleryData.jdField_a_of_type_JavaLangString = paramStructMsgForImageShare.optString("game_source_pic_txt");
      localGameShareGalleryData.jdField_b_of_type_JavaLangString = paramStructMsgForImageShare.optString("game_source_pic_url");
      localGameShareGalleryData.jdField_a_of_type_Int = paramStructMsgForImageShare.optInt("game_source_type_pic", 0);
      localGameShareGalleryData.jdField_b_of_type_Int = paramStructMsgForImageShare.optInt("game_source_subtype_pic", 0);
      localGameShareGalleryData.jdField_a_of_type_Boolean = paramStructMsgForImageShare.optBoolean("game_source_pic_has_data");
      return localGameShareGalleryData;
    }
    catch (Throwable paramStructMsgForImageShare)
    {
      QLog.e("GameShare.Util", 1, paramStructMsgForImageShare, new Object[0]);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramString1 = paramMessageRecord.getExtInfoFromExtStr(paramString1);
      if (!TextUtils.isEmpty(paramString1)) {}
    }
    else
    {
      return paramString2;
    }
    return paramString1;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public static void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean, Resources paramResources, Context paramContext, AbsStructMsg paramAbsStructMsg)
  {
    try
    {
      if (!a(paramAbsStructMsg)) {
        return;
      }
      localStructMsgForImageShare = (StructMsgForImageShare)paramAbsStructMsg;
      if ((!a(localStructMsgForImageShare)) || (paramView == null) || (paramRelativeLayout == null) || (paramResources == null) || (paramContext == null) || (paramAbsStructMsg.message == null)) {
        return;
      }
      if (!(paramView instanceof TextView)) {
        break label748;
      }
      paramView = (TextView)paramView;
      paramView.setBackgroundDrawable(null);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    catch (Throwable paramView)
    {
      StructMsgForImageShare localStructMsgForImageShare;
      Object localObject;
      int i;
      int j;
      while (QLog.isColorLevel())
      {
        QLog.e("GameShare.Util", 1, paramView, new Object[0]);
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131364634);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364643);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, paramResources);
        continue;
        label745:
        continue;
        label748:
        paramView = null;
      }
    }
    paramRelativeLayout.setBackgroundResource(2130842803);
    localObject = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131364634);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, paramResources);
      paramRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramContext);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(6, 2131378559);
      paramContext.addRule(1, 2131378559);
      paramContext.addRule(11, -1);
      paramContext.addRule(8, 2131378559);
      paramContext.addRule(15, -1);
      paramContext.rightMargin = AIOUtils.a(8.0F, paramResources);
      paramRelativeLayout.addView((View)localObject, paramContext);
      ((TextView)localObject).setGravity(21);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setSingleLine(true);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(2, 12.0F);
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(5.0F, paramResources));
      paramRelativeLayout = paramResources.getDrawable(2130848924);
      paramRelativeLayout.setBounds(0, 0, AIOUtils.a(6.0F, paramResources), AIOUtils.a(10.0F, paramResources));
      ((TextView)localObject).setCompoundDrawables(null, null, paramRelativeLayout, null);
      paramRelativeLayout = a("game_source_aio_txt", "", paramAbsStructMsg.message);
      if (!TextUtils.isEmpty(paramRelativeLayout)) {
        break label745;
      }
      GameShareNetHelper.a().a(localStructMsgForImageShare.mSourceAppid, localStructMsgForImageShare.message);
      paramRelativeLayout = "有新动态";
      paramContext = a("game_source_aio_url", "", paramAbsStructMsg.message);
      paramResources = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        paramResources = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87006&appid=" + localStructMsgForImageShare.mSourceAppid;
      }
      i = a("game_source_type_aio", 0, paramAbsStructMsg.message);
      j = a("game_source_subtype_aio", 0, paramAbsStructMsg.message);
      paramContext = localStructMsgForImageShare.mSourceAppid + "";
      if (paramView != null)
      {
        paramView.setTag(-1, paramResources);
        paramView.setTag(-5, Integer.valueOf(0));
        paramView.setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
        QWalletTools.a(paramView, 0.5F);
      }
      ((TextView)localObject).setText(paramRelativeLayout);
      ((TextView)localObject).setTag(-1, paramResources);
      ((TextView)localObject).setTag(-2, Integer.valueOf(i));
      ((TextView)localObject).setTag(-3, Integer.valueOf(j));
      ((TextView)localObject).setTag(-4, paramContext);
      ((TextView)localObject).setTag(-5, Integer.valueOf(1));
      ((TextView)localObject).setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
      QWalletTools.a((View)localObject, 0.5F);
      paramView = (Integer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramAbsStructMsg.message.uniseq));
      if ((paramView != null) && (paramView.intValue() == j)) {
        return;
      }
      paramView = new HashMap();
      paramView.put(Integer.valueOf(2), j + "");
      paramView.put(Integer.valueOf(4), "8");
      GameCenterUtils.a(null, "870", "206672", paramContext, "87006", "1", "145", paramView);
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramAbsStructMsg.message.uniseq), Integer.valueOf(j));
    }
  }
  
  public static void a(TextView paramTextView, Context paramContext, AIOImageData paramAIOImageData, AIOGallerySceneWithBusiness paramAIOGallerySceneWithBusiness)
  {
    if ((paramTextView == null) || (paramContext == null) || (paramAIOImageData == null)) {
      return;
    }
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    GameShareUtil.GameShareGalleryData localGameShareGalleryData = a(localStructMsgForImageShare);
    if ((localGameShareGalleryData != null) && (!TextUtils.isEmpty(localGameShareGalleryData.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localGameShareGalleryData.jdField_b_of_type_JavaLangString)))
    {
      Object localObject1 = localStructMsgForImageShare.mSourceAppid + "";
      paramTextView.setVisibility(0);
      paramTextView.setText(localGameShareGalleryData.jdField_a_of_type_JavaLangString);
      paramTextView.setTag(-1, localGameShareGalleryData.jdField_b_of_type_JavaLangString);
      paramTextView.setTag(-4, localObject1);
      paramTextView.setTag(-2, Integer.valueOf(localGameShareGalleryData.jdField_a_of_type_Int));
      paramTextView.setTag(-3, Integer.valueOf(localGameShareGalleryData.jdField_b_of_type_Int));
      paramTextView.setTag(-5, Integer.valueOf(2));
      a((String)localObject1, localGameShareGalleryData.jdField_b_of_type_Int, paramAIOImageData);
      paramTextView.setOnClickListener(jdField_a_of_type_AndroidViewView$OnClickListener);
      QWalletTools.a(paramTextView, 0.5F);
      localObject1 = localStructMsgForImageShare.mSourceIcon;
      Object localObject2 = paramContext.getResources();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = ((Resources)localObject2).getDrawable(2130850896);
        ((Drawable)localObject3).setBounds(0, 0, AIOUtils.a(20.0F, (Resources)localObject2), AIOUtils.a(20.0F, (Resources)localObject2));
        Object localObject4 = new BitmapDrawable(StructMsgItemCover.a((Drawable)localObject3));
        paramTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, (Resources)localObject2));
        ((Drawable)localObject4).setBounds(0, 0, AIOUtils.a(20.0F, (Resources)localObject2), AIOUtils.a(20.0F, (Resources)localObject2));
        paramTextView.setCompoundDrawables((Drawable)localObject4, null, null, null);
        localObject4 = ((Resources)localObject2).getDrawable(2130850897);
        ((Drawable)localObject4).setBounds(0, 0, AIOUtils.a(20.0F, (Resources)localObject2), AIOUtils.a(20.0F, (Resources)localObject2));
        localObject1 = URLDrawable.getDrawable((String)localObject1, (Drawable)localObject3, (Drawable)localObject4);
        localObject2 = new WeakReference(paramContext);
        localObject3 = new WeakReference(paramTextView);
        paramAIOGallerySceneWithBusiness = new WeakReference(paramAIOGallerySceneWithBusiness);
        long l1 = paramAIOImageData.jdField_f_of_type_Long;
        long l2 = paramAIOImageData.jdField_f_of_type_Int;
        ((IQWalletPicHelper)QRoute.api(IQWalletPicHelper.class)).decodeDrawable((Drawable)localObject1, new GameShareUtil.2((WeakReference)localObject2, (WeakReference)localObject3, paramAIOGallerySceneWithBusiness, l1, l2));
        if (!localGameShareGalleryData.jdField_a_of_type_Boolean) {
          GameShareNetHelper.a().a(localStructMsgForImageShare.mSourceAppid, new GameShareUtil.3((WeakReference)localObject2, (WeakReference)localObject3, paramAIOGallerySceneWithBusiness, l1, l2, paramAIOImageData));
        }
      }
    }
    for (;;)
    {
      paramContext = paramContext.getResources();
      paramTextView.setPadding(AIOUtils.a(5.0F, paramContext), 0, AIOUtils.a(14.0F, paramContext), 0);
      return;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if ((paramAIOImageData == null) || (paramStructMsgForImageShare == null)) {
      return;
    }
    String str1 = a("game_source_pic_txt", "", paramStructMsgForImageShare.message);
    String str2 = a("game_source_pic_url", "", paramStructMsgForImageShare.message);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        str1 = "有新动态";
        str2 = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87007&appid=" + paramStructMsgForImageShare.mSourceAppid;
      }
      a(paramAIOImageData, paramStructMsgForImageShare, str1, str2, a("game_source_type_pic", 0, paramStructMsgForImageShare.message), a("game_source_subtype_pic", 0, paramStructMsgForImageShare.message), bool);
      return;
    }
  }
  
  public static void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("game_source_pic_txt", paramString1);
      localJSONObject.put("game_source_pic_url", paramString2);
      localJSONObject.put("game_source_type_pic", paramInt1);
      localJSONObject.put("game_source_subtype_pic", paramInt2);
      localJSONObject.put("game_source_pic_has_data", paramBoolean);
      paramStructMsgForImageShare.mMsgActionData = localJSONObject.toString();
      paramAIOImageData.a = paramStructMsgForImageShare.getBytes();
      return;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QLog.e("GameShare.Util", 1, paramString1, new Object[0]);
      }
    }
  }
  
  public static void a(StructMsgForImageShare paramStructMsgForImageShare, ImageView paramImageView, StructMsgItemImage paramStructMsgItemImage)
  {
    int i;
    int j;
    if ((a(paramStructMsgForImageShare)) && (a(paramStructMsgForImageShare)) && (paramImageView != null) && (paramStructMsgItemImage != null))
    {
      i = AIOUtils.a(paramStructMsgItemImage.q, paramImageView.getContext().getResources());
      j = AIOUtils.a(paramStructMsgItemImage.r, paramImageView.getContext().getResources());
      if (Build.VERSION.SDK_INT < 16) {
        break label92;
      }
      if (i > paramImageView.getMaxWidth()) {
        paramImageView.setMaxWidth(i);
      }
      if (j > paramImageView.getMaxHeight()) {
        paramImageView.setMaxHeight(j);
      }
    }
    return;
    label92:
    paramImageView.setMaxWidth(i);
    paramImageView.setMaxHeight(j);
  }
  
  public static void a(StructMsgForImageShare paramStructMsgForImageShare, MessageForPic paramMessageForPic, StructMsgItemImage paramStructMsgItemImage)
  {
    if ((a(paramStructMsgForImageShare)) && (a(paramStructMsgForImageShare)) && (paramStructMsgItemImage != null)) {
      if (paramMessageForPic != null) {
        break label96;
      }
    }
    label96:
    for (paramStructMsgForImageShare = null;; paramStructMsgForImageShare = paramMessageForPic.thumbWidthHeightDP)
    {
      if (paramStructMsgForImageShare != null)
      {
        paramStructMsgForImageShare.mMinWidth = 251;
        paramStructMsgForImageShare.mMaxWidth = Math.max(paramStructMsgForImageShare.mMinWidth, paramStructMsgForImageShare.mMaxWidth);
        paramStructMsgForImageShare.mMaxHeight = Math.max(paramStructMsgForImageShare.mMaxHeight, paramStructMsgForImageShare.mMinWidth);
        paramStructMsgItemImage.q = Math.max(paramStructMsgForImageShare.mMaxWidth, paramStructMsgItemImage.q);
        paramStructMsgItemImage.r = Math.max(paramStructMsgForImageShare.mMaxHeight, paramStructMsgItemImage.r);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, Object paramObject)
  {
    Object localObject = (Integer)jdField_a_of_type_JavaUtilMap.get(paramObject);
    if ((localObject == null) || (((Integer)localObject).intValue() != paramInt))
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), paramInt + "");
      ((Map)localObject).put(Integer.valueOf(4), "8");
      GameCenterUtils.a(null, "870", "206673", paramString, "87007", "1", "145", (Map)localObject);
      jdField_a_of_type_JavaUtilMap.put(paramObject, Integer.valueOf(paramInt));
    }
  }
  
  public static void a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramString2))) {
      paramMessageRecord.saveExtInfoToExtStr(paramString1, paramString2);
    }
  }
  
  public static boolean a(long paramLong)
  {
    try
    {
      GameShareConfBean localGameShareConfBean = GameShareConfProcessor.a();
      if (localGameShareConfBean != null)
      {
        boolean bool = localGameShareConfBean.a(paramLong + "");
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GameShare.Util", 1, localThrowable, new Object[0]);
      }
    }
    return false;
  }
  
  public static boolean a(AbsShareMsg paramAbsShareMsg)
  {
    return (paramAbsShareMsg != null) && (a(paramAbsShareMsg.mSourceAppid));
  }
  
  private static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForImageShare)) {
      return a((AbsShareMsg)paramAbsStructMsg);
    }
    return false;
  }
  
  private static boolean a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    return paramStructMsgForImageShare.width >= paramStructMsgForImageShare.height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareUtil
 * JD-Core Version:    0.7.0.1
 */