package com.tencent.mobileqq.structmsg;

import aftk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bdod;
import bdpl;
import bdpo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public abstract class AbsStructMsg
  implements bdod, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = anvx.a(2131699225);
  public static final String PA_DEFAULT_MSG_BRIEF = anvx.a(2131699224);
  public static int SOURCE_ACCOUNT_TYPE_PA = 7;
  public String adverKey;
  public int adverSign;
  public String currentAccountUin;
  public int dynamicMsgMergeIndex = -1;
  public String dynamicMsgMergeKey = "";
  public boolean forceDoNotCompress = AppSetting.d();
  public int forwardID;
  public int fwFlag;
  public String index;
  public String index_name;
  public String index_type;
  public String mAlgorithmIds;
  public String mArticleIds;
  public String mCommentText;
  public String mCommonData;
  public String mCompatibleText = "";
  public String mCreateTime;
  public boolean mEmptyMsgBriefModified;
  public String mExtraData;
  public String mFileName;
  public long mFileSize;
  public int mFlag;
  public String mInnerUniqIds;
  public String mMergeSeq;
  public String mMsgAction = "web";
  public String mMsgActionData;
  public String mMsgBrief;
  public String mMsgOldText;
  public int mMsgServiceID = -1;
  public int mMsgTemplateID = -1;
  public String mMsgUrl;
  public String mMsg_A_ActionData;
  public String mMsg_I_ActionData;
  public String mNeedRound;
  public String mOrangeWord;
  public int mPromotionMenuDestructiveIndex = -1;
  public String mPromotionMenus = "";
  public String mPromotionMsg = "";
  public int mPromotionType;
  public String mQQStoryExtra;
  public String mQidianBulkTaskId;
  public String mQzoneExtraMsg;
  public String mResid;
  public String mSType;
  public long mSortKey;
  public String mSourceThirdName;
  public String mStrategyIds;
  public int mTSum;
  public String mTagName;
  public String mTribeShortVideoExtra;
  public int mVersion = 1;
  public MessageRecord message;
  public int messageVersion;
  public long msgId;
  public int multiMsgFlag;
  public long parentUniseq;
  public String readInjoy = "QQ看点";
  public String reportEventFolderStatusValue;
  public String rijAlbumActionData;
  public int sourceAccoutType;
  public String source_puin = "";
  public String templateIDForPortal = "";
  public String uin;
  public int uinType;
  public long uniseq;
  
  AbsStructMsg() {}
  
  AbsStructMsg(Bundle paramBundle)
  {
    this.mMsgTemplateID = 1;
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
    this.mMsgActionData = "";
    this.mMsgUrl = paramBundle.getString("detail_url");
    this.mQzoneExtraMsg = paramBundle.getString("qzone_extra_msg");
    this.mMsg_A_ActionData = "";
    this.mCommentText = paramBundle.getString("share_comment_message");
    this.source_puin = paramBundle.getString("source_puin");
    if ((this.source_puin == null) || (this.source_puin.equals(""))) {
      this.source_puin = paramBundle.getString("struct_uin");
    }
    if (this.source_puin == null) {
      this.source_puin = "";
    }
    if (this.msgId == 0L) {
      paramBundle = paramBundle.getString("strurt_msgid");
    }
    try
    {
      this.msgId = Long.parseLong(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  AbsStructMsg(bdpl parambdpl)
  {
    parseMsgAttrubutes(parambdpl);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, aftk paramaftk, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramaftk, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, aftk paramaftk, Bundle paramBundle, String paramString)
  {
    paramaftk = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      paramBundle = new TextView(paramContext);
      paramBundle.setText(paramString);
      paramBundle.setTextSize(2, 14.0F);
      paramBundle.setTextColor(Color.parseColor("#777777"));
      int i = AIOUtils.dp2px(15.0F, paramaftk);
      int j = AIOUtils.dp2px(7.5F, paramaftk);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130838348);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131378139);
      paramaftk = new RelativeLayout.LayoutParams(-2, -2);
      paramaftk.addRule(13);
      paramView.addView(paramContext, paramaftk);
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getInCompatibleView(Context paramContext, View paramView, String paramString)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramContext = new TextView(paramContext);
      paramContext.setText(paramString);
      paramContext.setTextSize(2, 16.0F);
      paramContext.setTextColor(Color.parseColor("#000000"));
      int i = BaseChatItemLayout.o;
      int j = BaseChatItemLayout.p;
      paramView.setBackgroundResource(2130838348);
      paramContext.setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, aftk paramaftk, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramaftk, paramBundle, 2131698256);
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public void addFlag(int paramInt)
  {
    if ((this.mFlag & paramInt) == paramInt) {
      return;
    }
    this.mFlag |= paramInt;
  }
  
  public abstract byte[] getBytes();
  
  public abstract View getPreDialogView(Context paramContext, View paramView);
  
  public abstract String getSourceName();
  
  public abstract View getSourceView(Context paramContext, View paramView);
  
  public View getView(Context paramContext, View paramView, aftk paramaftk, Bundle paramBundle)
  {
    paramaftk = paramView;
    if (paramView == null)
    {
      paramaftk = new LinearLayout(paramContext);
      paramaftk.setOrientation(1);
      paramContext = paramaftk.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    for (;;)
    {
      paramaftk.setLayoutParams(paramContext);
      return paramaftk;
      label49:
      paramContext.width = BaseChatItemLayout.B;
      paramContext.height = -2;
    }
  }
  
  public final String getXml()
  {
    Object localObject = new ByteArrayOutputStream();
    toXml((ByteArrayOutputStream)localObject, "UTF-8");
    try
    {
      localObject = ((ByteArrayOutputStream)localObject).toString("UTF-8");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final byte[] getXmlBytes()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    toXml(localByteArrayOutputStream, "UTF-8");
    byte[] arrayOfByte;
    if (QLog.isDevelopLevel()) {
      arrayOfByte = null;
    }
    try
    {
      localObject = localByteArrayOutputStream.toString("UTF-8");
      QLog.d("StructMsg", 4, "Obj[" + System.identityHashCode(this) + "]getXmlBytes xmlStr:" + (String)localObject);
      if (!isForceDoNotCompress())
      {
        j = 1;
        if (j == 0) {
          break label170;
        }
        localObject = bdpo.b(localByteArrayOutputStream.toByteArray());
        if (j == 0) {
          break label179;
        }
        j = 1;
        int i = (byte)j;
        j = localObject.length;
        arrayOfByte = new byte[j + 1];
        arrayOfByte[0] = i;
        System.arraycopy(localObject, 0, arrayOfByte, 1, j);
        return arrayOfByte;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int j;
        Object localObject = arrayOfByte;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
          localObject = arrayOfByte;
          continue;
          j = 0;
          continue;
          label170:
          localObject = localByteArrayOutputStream.toByteArray();
          continue;
          label179:
          j = 0;
        }
      }
    }
  }
  
  public boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  public boolean hasTSum()
  {
    return this.mTSum > 0;
  }
  
  public boolean isForceDoNotCompress()
  {
    return false;
  }
  
  protected void parseMsgAttrubutes(bdpl parambdpl)
  {
    if (parambdpl == null) {}
    for (;;)
    {
      return;
      String str1 = parambdpl.a("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = parambdpl.a("url");
      this.mMsgAction = parambdpl.a("action");
      this.mMsgActionData = parambdpl.a("actionData");
      this.mMsg_A_ActionData = parambdpl.a("a_actionData");
      this.mMsg_I_ActionData = parambdpl.a("i_actionData");
      this.rijAlbumActionData = parambdpl.a("rijAlbumActionData");
      this.mQzoneExtraMsg = parambdpl.a("qzFloatExtra");
      str1 = parambdpl.a("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label128:
        str1 = parambdpl.a("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label151:
          str1 = parambdpl.a("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = parambdpl.a("brief");
          this.mResid = parambdpl.a("m_resid");
          this.mFileName = parambdpl.a("m_fileName");
          str1 = parambdpl.a("tSum");
          if (!TextUtils.isEmpty(str1)) {
            this.mTSum = Integer.parseInt(str1);
          }
          str1 = parambdpl.a("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label253:
            str1 = parambdpl.a("promotionType");
            this.mPromotionMsg = parambdpl.a("promotionMsg");
            this.mPromotionMenus = parambdpl.a("promotionMenus");
            String str2 = parambdpl.a("promotionMenuDestructiveIndex");
            label392:
            label426:
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.mPromotionType = Integer.parseInt(str1);
              }
              if (!TextUtils.isEmpty(str2)) {
                this.mPromotionMenuDestructiveIndex = Integer.parseInt(str2);
              }
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              label321:
              label449:
              break label321;
            }
            this.source_puin = parambdpl.a("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = parambdpl.a("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = parambdpl.a("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = parambdpl.a("sType");
              str1 = parambdpl.a("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                str1 = parambdpl.a("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = parambdpl.a("adverKey");
                  this.index = parambdpl.a("index");
                  this.index_name = parambdpl.a("index_name");
                  this.index_type = parambdpl.a("index_type");
                  this.mExtraData = parambdpl.a("extraData");
                  this.mCreateTime = parambdpl.a("createTime");
                  this.mTagName = parambdpl.a("tagName");
                  this.mArticleIds = parambdpl.a("articleIds");
                  this.mOrangeWord = parambdpl.a("orangeWord");
                  this.mAlgorithmIds = parambdpl.a("algorithmIds");
                  this.mStrategyIds = parambdpl.a("strategyIds");
                  this.reportEventFolderStatusValue = parambdpl.a("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = parambdpl.a("qf_task_id");
                  this.mInnerUniqIds = parambdpl.a("uuids");
                  this.mQQStoryExtra = parambdpl.a("qqstoryExtra");
                  this.mTribeShortVideoExtra = parambdpl.a("qqtribeVideoInfoExtra");
                  this.mNeedRound = parambdpl.a("needRoundView");
                  this.mCommonData = parambdpl.a("msgCommonData");
                  this.mMergeSeq = parambdpl.a("mergeSeq");
                  parambdpl = parambdpl.a("sortKey");
                  try
                  {
                    if (!TextUtils.isEmpty(parambdpl)) {
                      this.mSortKey = Long.parseLong(parambdpl);
                    }
                    if (((this.mMsgServiceID != 142) && (this.mMsgServiceID != 500)) || (!TextUtils.isEmpty(this.mExtraData)) || (TextUtils.isEmpty(this.mMsgActionData))) {
                      continue;
                    }
                    try
                    {
                      this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
                      return;
                    }
                    catch (Exception parambdpl)
                    {
                      parambdpl.getStackTrace();
                      return;
                    }
                  }
                  catch (NumberFormatException parambdpl)
                  {
                    for (;;)
                    {
                      parambdpl.printStackTrace();
                    }
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  break label449;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                break label426;
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              break label392;
            }
          }
          catch (NumberFormatException localNumberFormatException5)
          {
            break label253;
          }
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          break label151;
        }
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        break label128;
      }
    }
  }
  
  public void removeFlag(int paramInt)
  {
    this.mFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setFlag(int paramInt)
  {
    this.mFlag = paramInt;
  }
  
  protected abstract void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */