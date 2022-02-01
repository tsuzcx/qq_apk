package com.tencent.mobileqq.structmsg;

import agej;
import agsg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import azrg;
import bbai;
import bcpt;
import bcry;
import bcsa;
import bdmc;
import bdoh;
import bdok;
import bdol;
import bdom;
import bdoq;
import bdov;
import bdqc;
import bdqf;
import bdqo;
import bdqr;
import bdqs;
import bdre;
import bdrv;
import bdso;
import bdtj;
import bdtr;
import betj;
import beyb;
import beyq;
import bhkj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsShareMsg
  extends AbsStructMsg
  implements Iterable<bdol>
{
  public static final int PACKAGE_NAME_INDEX = 0;
  public static final int URL_DATA_INDEX = 1;
  public int forwardType;
  public String mAdSourceIcon;
  public String mAdSourceMenu;
  public String mAdSourceName;
  public String mContentCover;
  public int mContentLayout = -1;
  public String mContentSrc;
  public String mContentSummary;
  public String mContentTitle;
  JSONObject mDatas = null;
  public boolean mHasAdSource;
  public boolean mHasSource;
  public boolean mMsgException;
  public String mSourceAction;
  public String mSourceActionData;
  public long mSourceAppid = -1L;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new bdoh(this);
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mSource_I_ActionData;
  public List<bdol> mStructMsgItemLists = new ArrayList();
  public AbsShareMsg.ShareData shareData = new AbsShareMsg.ShareData();
  
  AbsShareMsg()
  {
    this.mVersion = 28;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mVersion = 28;
    this.mContentCover = paramBundle.getString("image_url_remote");
    if (this.mContentCover != null)
    {
      this.shareData.imageUrlStatus = paramBundle.getByte("struct_share_key_image_url_status", (byte)4).byteValue();
      this.mContentTitle = paramBundle.getString("title");
      this.mContentSummary = paramBundle.getString("desc");
      if (this.mContentTitle != null) {
        this.mContentTitle = bcsa.a(this.mContentTitle, false);
      }
      if (this.mContentSummary != null) {
        this.mContentSummary = bcsa.a(this.mContentSummary, false);
      }
      this.mMsgAction = paramBundle.getString("struct_share_key_content_action");
      this.mMsgActionData = paramBundle.getString("struct_share_key_content_action_DATA");
      this.mMsg_A_ActionData = paramBundle.getString("struct_share_key_content_a_action_DATA");
      this.mMsg_I_ActionData = paramBundle.getString("struct_share_key_content_i_action_DATA");
      this.mSourceAppid = paramBundle.getLong("req_share_id", -1L);
      this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
      this.mSourceAction = paramBundle.getString("struct_share_key_source_action");
      if (TextUtils.isEmpty(this.mSourceAction)) {
        this.mSourceAction = "app";
      }
      this.mSourceActionData = paramBundle.getString("struct_share_key_source_action_data");
      this.mSource_A_ActionData = paramBundle.getString("struct_share_key_source_a_action_data");
      this.mSource_I_ActionData = paramBundle.getString("struct_share_key_source_i_action_data");
      if ((TextUtils.isEmpty(this.mSource_I_ActionData)) && (this.mSourceAppid > 0L) && (!"plugin".equals(this.mSourceAction))) {
        this.mSource_I_ActionData = String.format("tencent%d://", new Object[] { Long.valueOf(this.mSourceAppid) });
      }
      this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
      this.mSourceName = paramBundle.getString("struct_share_key_source_name");
      this.forwardType = paramBundle.getInt("forward_type");
      if ((this.forwardType != 11) && (TextUtils.isEmpty(this.mSourceName))) {
        this.mSourceName = paramBundle.getString("app_name");
      }
      this.mMsgBrief = paramBundle.getString("brief_key");
      if (TextUtils.isEmpty(this.mMsgBrief))
      {
        if (TextUtils.isEmpty(this.mSourceName)) {
          break label1019;
        }
        this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });
      }
      label437:
      this.mResid = paramBundle.getString("mm_resid");
      this.mFileName = paramBundle.getString("mm_file_name");
      this.mFileSize = paramBundle.getLong("mm_file_size");
      this.mCompatibleText = paramBundle.getString("compatible_text");
      this.fwFlag = paramBundle.getInt("is_share_flag", 0);
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
        if (!TextUtils.isEmpty(this.mSourceName)) {
          break label1029;
        }
      }
    }
    label1029:
    for (this.mContentTitle = ao;; this.mContentTitle = String.format(an, new Object[] { this.mSourceName }))
    {
      this.mNeedRound = paramBundle.getString("icon_need_round");
      this.mFlag = paramBundle.getInt("flag");
      this.shareData.appInfoStatus = paramBundle.getByte("struct_share_key_app_info_status", (byte)0).byteValue();
      this.shareData.sourceIconBig = paramBundle.getString("struct_share_key_source_icon_big");
      this.shareData.pkgName = paramBundle.getString("pkg_name");
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mResid = " + this.mResid + ", mFileName = " + this.mFileName + ", mFileSize = " + this.mFileSize + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource + ", mSType = " + this.mSType);
      }
      return;
      this.mContentCover = paramBundle.getString("image_url");
      this.shareData.imageUrlStatus = 2;
      break;
      label1019:
      this.mMsgBrief = DEFAULT_MSG_BRIEF;
      break label437;
    }
  }
  
  AbsShareMsg(bdqc parambdqc)
  {
    super(parambdqc);
    this.mVersion = 28;
    int m = parambdqc.a();
    int i = 0;
    if (i < m)
    {
      bdqc localbdqc = parambdqc.a(i);
      int k;
      if (localbdqc == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localbdqc.b.equals("source"))
        {
          parseSourceNode(localbdqc);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if (localbdqc.b.equals("sourceAd"))
        {
          parseAdSourceNode(localbdqc);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if ((this.mMsgServiceID == 128) && (localbdqc.b.equals("data")))
        {
          parseDataNode(localbdqc);
          k = j;
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localbdqc))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    if (!TextUtils.isEmpty(this.mSourceAction)) {
      return false;
    }
    if ((this.mStructMsgItemLists == null) || (this.mStructMsgItemLists.isEmpty())) {
      return false;
    }
    Object localObject = (bdol)this.mStructMsgItemLists.get(0);
    if (!(localObject instanceof bdso)) {
      return false;
    }
    localObject = (bdso)localObject;
    if ((((bdso)localObject).a == null) || (((bdso)localObject).a.isEmpty())) {
      return false;
    }
    localObject = (bdol)((bdso)localObject).a.get(0);
    if (!(localObject instanceof bdqr)) {
      return false;
    }
    return ((bdqr)localObject).a();
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    bdmc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "doReport msg:" + paramAbsShareMsg);
    }
  }
  
  public static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label60;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label60:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public static void resendSdkFakeMessage(MessageForArkApp paramMessageForArkApp, JSONObject paramJSONObject, azrg paramazrg)
  {
    paramMessageForArkApp = betj.a(paramMessageForArkApp, paramJSONObject, paramazrg);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(paramMessageForArkApp);
  }
  
  public static void resendSdkShareMessage(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    paramMessageRecord = bcry.a(paramMessageRecord);
    agsg.a().a(paramMessageRecord.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.a().a(paramMessageRecord, MessageHandler.e);
    paramMessageRecord = betj.a(paramMessageRecord, paramAbsShareMsg);
    paramQQAppInterface.a().a(paramMessageRecord);
  }
  
  public static MessageForArkApp sendSdkFakeMessage(Bundle paramBundle, QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, azrg paramazrg)
  {
    paramBundle = bhkj.a(paramBundle, paramQQAppInterface, paramString1, paramInt, paramString2);
    agsg.a().a(paramBundle.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.a().a(paramBundle, MessageHandler.e);
    paramAbsShareMsg = betj.a(paramBundle, paramAbsShareMsg, paramazrg);
    QLog.d("StructMsg", 1, new Object[] { "sendSdkFakeMessage uinType=", Integer.valueOf(paramInt), ", groupUin=", paramString2, ", done=", Boolean.valueOf(paramQQAppInterface.a().a(paramAbsShareMsg)) });
    return paramBundle;
  }
  
  public static void sendSdkShareMessage(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2)
  {
    int i = bcpt.a;
    bcpt.a = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = bcry.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      agsg.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramQQAppInterface.a().a(paramString1, MessageHandler.f);
      paramAbsShareMsg = betj.a(paramString1, paramAbsShareMsg);
      paramQQAppInterface.a().a(paramAbsShareMsg);
      return;
    }
  }
  
  public static void sendSdkShareMessageByServer(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, azrg paramazrg)
  {
    int i = bcpt.a;
    bcpt.a = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = bcry.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      agsg.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramAbsShareMsg = betj.a(paramString1, paramAbsShareMsg, paramazrg);
      QLog.d("StructMsg", 1, new Object[] { "sendSdkShareMessageByServer done=", Boolean.valueOf(paramQQAppInterface.a().a(paramAbsShareMsg)) });
      return;
    }
  }
  
  public void addItem(bdol parambdol)
  {
    this.mStructMsgItemLists.add(parambdol);
  }
  
  public void addItems(List<bdol> paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public void clearItems()
  {
    this.mStructMsgItemLists.clear();
  }
  
  public bdol findXmlNode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = getItemCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = getItemByIndex(i);
      if (localObject == null) {
        label32:
        break label61;
      }
      label61:
      label98:
      do
      {
        do
        {
          i += 1;
          break;
          if (!(localObject instanceof bdom)) {
            break label98;
          }
          localObject = ((bdom)localObject).a.iterator();
        } while (!((Iterator)localObject).hasNext());
        bdol localbdol = (bdol)((Iterator)localObject).next();
        if (!paramString.equals(localbdol.a)) {
          break label32;
        }
        return localbdol;
      } while (!paramString.equals(((bdol)localObject).a));
      return localObject;
    }
    return null;
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public bdol getItemByIndex(int paramInt)
  {
    return (bdol)this.mStructMsgItemLists.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mStructMsgItemLists.size();
  }
  
  public abstract View.OnClickListener getOnClickListener();
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "AbsShareMsg getPreDialogView start!");
    }
    HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label310;
        }
        Object localObject2 = (bdol)localIterator.next();
        View localView = ((bdol)localObject2).a(paramContext, paramView, (Bundle)localObject1);
        if ((localView != null) && ((!(localObject2 instanceof bdso)) || (((bdso)localObject2).o != 1)))
        {
          if ((localObject2 instanceof bdre))
          {
            localTextView = (TextView)localView.findViewById(2131380141);
            if (localTextView != null)
            {
              localObject2 = (bdre)localObject2;
              if ((((bdre)localObject2).o != 1) && (((bdre)localObject2).o != 3)) {
                break;
              }
              localTextView.setTextColor(-8355712);
            }
          }
          localHeightLimitedLinearLayout.addView(localView);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TextView localTextView;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
          continue;
          localTextView.setGravity(16);
          localTextView.setMaxLines(2);
          localTextView.setTextSize(14.0F);
          localTextView.setTextColor(paramContext.getResources().getColor(2131165657));
          if (TextUtils.isEmpty(localTextView.getText()))
          {
            localTextView.setText("");
            localTextView.setVisibility(0);
          }
        }
      }
      label310:
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
      }
    }
    return localHeightLimitedLinearLayout;
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool = this.mHasSource;
    if (this.mMsgServiceID == 35) {
      bool = false;
    }
    if (!bool) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      localTextView.setBackgroundResource(2130842582);
      Drawable localDrawable1;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        Object localObject = this.mSourceIcon;
        Drawable localDrawable2 = localResources.getDrawable(2130850462);
        localDrawable2.setBounds(0, 0, agej.a(12.0F, localResources), agej.a(12.0F, localResources));
        localDrawable1 = localResources.getDrawable(2130850463);
        localDrawable1.setBounds(0, 0, agej.a(12.0F, localResources), agej.a(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable2, localDrawable1);
          if (beyq.a(paramContext)) {
            break label278;
          }
          bool = true;
          ((URLDrawable)localObject).setAutoDownload(bool);
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            QLog.e("StructMsg", 1, paramContext.getMessage(), paramContext);
            paramContext = localDrawable1;
          }
        }
        setCompoundDrawable(localTextView, paramContext, localResources);
      }
      for (;;)
      {
        localTextView.setPadding(agej.a(5.0F, localResources), 0, agej.a(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        if (!a()) {
          break label314;
        }
        paramView.setClickable(false);
        QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        return paramView;
        label278:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
      label314:
      paramView.setClickable(true);
      return paramView;
    }
  }
  
  public List<bdol> getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    bdol localbdol;
    label118:
    do
    {
      for (;;)
      {
        try
        {
          if (this.mStructMsgItemLists != null)
          {
            Iterator localIterator = this.mStructMsgItemLists.iterator();
            if (localIterator.hasNext())
            {
              localObject = (bdol)localIterator.next();
              if (!(localObject instanceof bdqs)) {
                break label118;
              }
              localObject = ((bdqs)localObject).a.iterator();
              if (((Iterator)localObject).hasNext())
              {
                localbdol = (bdol)((Iterator)localObject).next();
                if (!(localbdol instanceof StructMsgItemTitle)) {
                  continue;
                }
                localStringBuffer.append(((StructMsgItemTitle)localbdol).ai);
                continue;
              }
              continue;
            }
          }
          return localStringBuffer.toString();
        }
        catch (Exception localException) {}
        if (!(localObject instanceof bdre)) {
          break;
        }
        localObject = (bdre)localObject;
        localStringBuffer.append("链接");
        localObject = ((bdre)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localbdol = (bdol)((Iterator)localObject).next();
          if ((localbdol instanceof StructMsgItemTitle)) {
            localStringBuffer.append(((StructMsgItemTitle)localbdol).ai);
          } else if ((localbdol instanceof bdtj)) {
            localStringBuffer.append(((bdtj)localbdol).ai);
          }
        }
      }
    } while (!(localObject instanceof bdrv));
    Object localObject = (bdrv)localObject;
    int i = 0;
    localObject = ((bdrv)localObject).a.iterator();
    label248:
    if (((Iterator)localObject).hasNext())
    {
      localbdol = (bdol)((Iterator)localObject).next();
      if (("type".equals(localbdol.a)) && ((localbdol instanceof bdtr))) {
        i = ((bdtr)localbdol).o;
      }
    }
    for (;;)
    {
      localStringBuffer.append("文本");
      for (;;)
      {
        localStringBuffer.append("回执消息");
        if (!this.message.isSend()) {
          break label363;
        }
        localStringBuffer.append(",查看阅读状态");
        break;
        localStringBuffer.append("图片");
        continue;
        localStringBuffer.append("语音");
      }
      label363:
      if ("1".equals(bbai.a(this.message)))
      {
        localStringBuffer.append(",已读");
        break;
      }
      localStringBuffer.append(",未读");
      break;
      break label248;
      switch (i)
      {
      }
    }
  }
  
  public boolean isSdkShareMsg()
  {
    return ForwardUtils.a(this.forwardType, this.mMsgServiceID);
  }
  
  public Iterator<bdol> iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected void parseAdSourceNode(bdqc parambdqc)
  {
    if (parambdqc == null) {}
    do
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        return;
        this.mAdSourceName = parambdqc.a("name");
        if (!this.mAdSourceName.equals("")) {
          this.mHasAdSource = true;
        }
        try
        {
          if (this.mHasAdSource)
          {
            localJSONObject1 = new JSONObject();
            JSONArray localJSONArray = new JSONArray();
            parambdqc = parambdqc.a;
            if ((parambdqc != null) && (!parambdqc.isEmpty()))
            {
              parambdqc = parambdqc.iterator();
              while (parambdqc.hasNext())
              {
                Object localObject = ((bdqc)parambdqc.next()).a;
                if ((localObject != null) && (!((List)localObject).isEmpty()))
                {
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    bdqc localbdqc = (bdqc)((Iterator)localObject).next();
                    JSONObject localJSONObject2 = new JSONObject();
                    localJSONObject2.put("icon_url", localbdqc.a("icon_url"));
                    localJSONObject2.put("action_type", localbdqc.a("action_type"));
                    localJSONObject2.put("title", localbdqc.a("title"));
                    localJSONObject2.put("action_url", localbdqc.a("action_url"));
                    localJSONArray.put(localJSONObject2);
                  }
                }
              }
            }
            localJSONObject1.put("menus", localJSONArray);
          }
        }
        catch (Exception parambdqc)
        {
          parambdqc.printStackTrace();
          return;
        }
      }
      this.mAdSourceMenu = localJSONObject1.toString();
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "mAdSourceMenu: " + this.mAdSourceMenu);
  }
  
  protected abstract boolean parseContentNode(bdqc parambdqc);
  
  protected void parseDataNode(bdqc parambdqc)
  {
    if (this.mDatas == null) {
      this.mDatas = new JSONObject();
    }
    if (("data".equals(parambdqc.b)) && (this.mMsgServiceID == 128) && (TextUtils.equals("2", parambdqc.a("msgtype")))) {}
    try
    {
      this.mDatas.put("groupcode", parambdqc.a("groupcode"));
      this.mDatas.put("groupname", parambdqc.a("groupname"));
      this.mDatas.put("msgseq", parambdqc.a("msgseq"));
      this.mDatas.put("msgtype", parambdqc.a("msgtype"));
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "parseDataNode json:" + this.mDatas.toString());
      }
      return;
    }
    catch (JSONException parambdqc)
    {
      for (;;)
      {
        QLog.d("StructMsg", 1, "parseDataNode error:" + parambdqc.getMessage());
      }
    }
  }
  
  protected void parseDefaultContentNode()
  {
    bdom localbdom = bdov.a(2);
    localbdom.a("", this.mMsgBrief, aq);
    addItem(localbdom);
  }
  
  protected void parseSourceNode(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return;
    }
    this.mSourceAppid = bdqf.a(parambdqc.a("appid"));
    this.mSourceName = parambdqc.a("name");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      this.mEmptyMsgBriefModified = true;
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label175;
      }
    }
    label175:
    for (this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });; this.mMsgBrief = DEFAULT_MSG_BRIEF)
    {
      this.mSourceIcon = parambdqc.a("icon");
      this.mSourceUrl = parambdqc.a("url");
      this.mSourceAction = parambdqc.a("action");
      this.mSourceActionData = parambdqc.a("actionData");
      this.mSource_A_ActionData = parambdqc.a("a_actionData");
      this.mSource_I_ActionData = parambdqc.a("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  public abstract void report(Object paramObject);
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    paramDrawable = new BitmapDrawable(bdqo.a(paramDrawable));
    paramTextView.setCompoundDrawablePadding(agej.a(3.0F, paramResources));
    paramDrawable.setBounds(0, 0, agej.a(14.0F, paramResources), agej.a(14.0F, paramResources));
    paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
  }
  
  public void setHasSource(boolean paramBoolean)
  {
    this.mHasSource = paramBoolean;
  }
  
  public void setSourceIcon(String paramString)
  {
    this.mSourceIcon = paramString;
  }
  
  public void setSourceName(String paramString)
  {
    this.mSourceName = paramString;
  }
  
  public void setStructMsgItemLists(List<bdol> paramList)
  {
    this.mStructMsgItemLists = paramList;
  }
  
  protected abstract void toContentXml(bdok parambdok);
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    int i = 1;
    bdok localbdok = new bdok(this, new bdoq());
    label797:
    label1064:
    try
    {
      localbdok.setOutput(paramByteArrayOutputStream, paramString);
      localbdok.startDocument(paramString, Boolean.valueOf(true));
      localbdok.startTag(null, "msg");
      localbdok.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localbdok.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction != null) {
        break label996;
      }
      paramByteArrayOutputStream = "";
      localbdok.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mMsgActionData)) {
        localbdok.attribute(null, "actionData", this.mMsgActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
        localbdok.attribute(null, "a_actionData", this.mMsg_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
        localbdok.attribute(null, "i_actionData", this.mMsg_I_ActionData);
      }
      if (this.mMsgBrief != null) {
        break label1004;
      }
      paramByteArrayOutputStream = "";
      label185:
      localbdok.attribute(null, "brief", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mResid)) {
        localbdok.attribute(null, "m_resid", this.mResid);
      }
      if (!TextUtils.isEmpty(this.mFileName)) {
        localbdok.attribute(null, "m_fileName", this.mFileName);
      }
      if (this.mTSum > 0) {
        localbdok.attribute(null, "tSum", String.valueOf(this.mTSum));
      }
      if (this.mFileSize > 0L) {
        localbdok.attribute(null, "m_fileSize", String.valueOf(this.mFileSize));
      }
      if (!TextUtils.isEmpty(this.source_puin)) {
        localbdok.attribute(null, "sourcePublicUin", this.source_puin);
      }
      localbdok.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
      if (this.fwFlag == 1) {
        localbdok.attribute(null, "fwflag", String.valueOf(this.fwFlag));
      }
      if (this.mMsgUrl != null) {
        break label1012;
      }
      paramByteArrayOutputStream = "";
      label371:
      localbdok.attribute(null, "url", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.rijAlbumActionData)) {
        localbdok.attribute(null, "rijAlbumActionData", this.rijAlbumActionData);
      }
      localbdok.attribute(null, "flag", String.valueOf(this.mFlag));
      if (!TextUtils.isEmpty(this.mSType)) {
        localbdok.attribute(null, "sType", this.mSType);
      }
      if (this.sourceAccoutType == SOURCE_ACCOUNT_TYPE_PA) {
        localbdok.attribute(null, "accostType", String.valueOf(SOURCE_ACCOUNT_TYPE_PA));
      }
      paramByteArrayOutputStream = String.valueOf(this.adverSign);
      if (!TextUtils.isEmpty(paramByteArrayOutputStream)) {
        localbdok.attribute(null, "adverSign", paramByteArrayOutputStream);
      }
      if (!TextUtils.isEmpty(this.adverKey)) {
        localbdok.attribute(null, "adverKey", this.adverKey);
      }
      if (!TextUtils.isEmpty(this.mExtraData)) {
        localbdok.attribute(null, "extraData", this.mExtraData);
      }
      if (!TextUtils.isEmpty(this.mCreateTime)) {
        localbdok.attribute(null, "createTime", this.mCreateTime);
      }
      if (!TextUtils.isEmpty(this.mTagName)) {
        localbdok.attribute(null, "tagName", this.mTagName);
      }
      if (!TextUtils.isEmpty(this.mSourceThirdName)) {
        localbdok.attribute(null, "sourceName", this.mSourceThirdName);
      }
      if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
        localbdok.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
      }
      if (!TextUtils.isEmpty(this.mTribeShortVideoExtra)) {
        localbdok.attribute(null, "qqtribeVideoInfoExtra", this.mTribeShortVideoExtra);
      }
      if (!TextUtils.isEmpty(this.mNeedRound)) {
        localbdok.attribute(null, "needRoundView", this.mNeedRound);
      }
      if (!TextUtils.isEmpty(this.mCommonData)) {
        localbdok.attribute(null, "msgCommonData", this.mCommonData);
      }
      localbdok.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
      if (!TextUtils.isEmpty(this.mQzoneExtraMsg)) {
        localbdok.attribute(null, "qzFloatExtra", this.mQzoneExtraMsg);
      }
      toContentXml(localbdok);
      if (this.mMsgServiceID != 128) {
        break label1064;
      }
    }
    catch (Exception paramByteArrayOutputStream)
    {
      label819:
      label996:
      label1004:
      label1012:
      label1020:
      while (QLog.isColorLevel())
      {
        QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        return;
        i = 0;
      }
    }
    if (i == 0)
    {
      localbdok.startTag(null, "source");
      if (this.mSourceName != null) {
        break label1020;
      }
      paramByteArrayOutputStream = "";
      localbdok.attribute(null, "name", paramByteArrayOutputStream);
      if (this.mSourceIcon != null) {
        break label1028;
      }
      paramByteArrayOutputStream = "";
      localbdok.attribute(null, "icon", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceUrl)) {
        localbdok.attribute(null, "url", this.mSourceUrl);
      }
      if (this.mSourceAction != null) {
        break label1036;
      }
    }
    label1028:
    label1036:
    for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceAction)
    {
      localbdok.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceActionData)) {
        localbdok.attribute(null, "actionData", this.mSourceActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
        localbdok.attribute(null, "a_actionData", this.mSource_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
        localbdok.attribute(null, "i_actionData", this.mSource_I_ActionData);
      }
      localbdok.attribute(null, "appid", String.valueOf(this.mSourceAppid));
      localbdok.endTag(null, "source");
      localbdok.endTag(null, "msg");
      localbdok.endDocument();
      localbdok.flush();
      return;
      paramByteArrayOutputStream = this.mMsgAction;
      break;
      paramByteArrayOutputStream = this.mMsgBrief;
      break label185;
      paramByteArrayOutputStream = this.mMsgUrl;
      break label371;
      paramByteArrayOutputStream = this.mSourceName;
      break label797;
      paramByteArrayOutputStream = this.mSourceIcon;
      break label819;
    }
  }
  
  public void updateCover(String paramString)
  {
    this.mContentCover = paramString;
  }
  
  public void updateTitleSummaryAndCover(String paramString1, String paramString2, String paramString3)
  {
    this.mContentTitle = paramString1;
    this.mContentSummary = paramString2;
    this.mContentCover = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */