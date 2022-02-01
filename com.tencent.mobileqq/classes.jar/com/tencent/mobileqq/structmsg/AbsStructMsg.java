package com.tencent.mobileqq.structmsg;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public abstract class AbsStructMsg
  implements StructMsgConstants, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = HardCodeUtil.a(2131699803);
  public static final String PA_DEFAULT_MSG_BRIEF = HardCodeUtil.a(2131699802);
  public static int SOURCE_ACCOUNT_TYPE_PA = 7;
  public String adverKey;
  public int adverSign;
  public String currentAccountUin;
  public int dynamicMsgMergeIndex = -1;
  public String dynamicMsgMergeKey = "";
  public boolean forceDoNotCompress = AppSetting.f();
  public int forwardID;
  public int fwFlag = 0;
  public String index;
  public String index_name;
  public String index_type;
  public String mAlgorithmIds = null;
  public String mArticleIds = null;
  public String mCommentText = null;
  public String mCommonData = null;
  public String mCompatibleText = "";
  public String mCreateTime = null;
  public boolean mEmptyMsgBriefModified = false;
  public String mExtraData = null;
  public String mFileName = null;
  public long mFileSize = 0L;
  int mFlag;
  public String mInnerUniqIds = null;
  public String mMergeSeq = null;
  public String mMsgAction = "web";
  public String mMsgActionData = null;
  public String mMsgBrief = null;
  public String mMsgOldText = null;
  public int mMsgServiceID = -1;
  public int mMsgTemplateID = -1;
  public String mMsgUrl = null;
  public String mMsg_A_ActionData = null;
  public String mMsg_I_ActionData = null;
  public String mNeedRound = null;
  public String mOrangeWord = null;
  public int mPromotionMenuDestructiveIndex = -1;
  public String mPromotionMenus = "";
  public String mPromotionMsg = "";
  public int mPromotionType = 0;
  public String mQQStoryExtra = null;
  public String mQidianBulkTaskId = null;
  public String mQzoneExtraMsg = null;
  public String mResid = null;
  public String mSType = null;
  public long mSortKey = 0L;
  public String mSourceThirdName = null;
  public String mStrategyIds = null;
  public int mTSum = 0;
  public String mTagName = null;
  public String mTribeShortVideoExtra = null;
  int mVersion = 1;
  public MessageRecord message;
  public int messageVersion;
  public long msgId = 0L;
  public int multiMsgFlag = 0;
  public long parentUniseq;
  public String readInjoy = "QQ看点";
  public String reportEventFolderStatusValue = null;
  public String rijAlbumActionData = null;
  public int sourceAccoutType = 0;
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
  
  AbsStructMsg(StructMsgNode paramStructMsgNode)
  {
    parseMsgAttrubutes(paramStructMsgNode);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle, String paramString)
  {
    paramOnLongClickAndTouchListener = paramContext.getResources();
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
      int i = AIOUtils.a(15.0F, paramOnLongClickAndTouchListener);
      int j = AIOUtils.a(7.5F, paramOnLongClickAndTouchListener);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130838417);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131378560);
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(13);
      paramView.addView(paramContext, paramOnLongClickAndTouchListener);
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
      paramView.setBackgroundResource(2130838417);
      paramContext.setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle, 2131698533);
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
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    paramOnLongClickAndTouchListener = paramView;
    if (paramView == null)
    {
      paramOnLongClickAndTouchListener = new LinearLayout(paramContext);
      paramOnLongClickAndTouchListener.setOrientation(1);
      paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      return paramOnLongClickAndTouchListener;
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
        localObject = StructMsgUtils.b(localByteArrayOutputStream.toByteArray());
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
  
  protected void parseMsgAttrubutes(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return;
      String str1 = paramStructMsgNode.a("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = paramStructMsgNode.a("url");
      this.mMsgAction = paramStructMsgNode.a("action");
      this.mMsgActionData = paramStructMsgNode.a("actionData");
      this.mMsg_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mMsg_I_ActionData = paramStructMsgNode.a("i_actionData");
      this.rijAlbumActionData = paramStructMsgNode.a("rijAlbumActionData");
      this.mQzoneExtraMsg = paramStructMsgNode.a("qzFloatExtra");
      str1 = paramStructMsgNode.a("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label128:
        str1 = paramStructMsgNode.a("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label151:
          str1 = paramStructMsgNode.a("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = paramStructMsgNode.a("brief");
          this.mResid = paramStructMsgNode.a("m_resid");
          this.mFileName = paramStructMsgNode.a("m_fileName");
          str1 = paramStructMsgNode.a("tSum");
          if (!TextUtils.isEmpty(str1)) {
            this.mTSum = Integer.parseInt(str1);
          }
          str1 = paramStructMsgNode.a("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label253:
            str1 = paramStructMsgNode.a("promotionType");
            this.mPromotionMsg = paramStructMsgNode.a("promotionMsg");
            this.mPromotionMenus = paramStructMsgNode.a("promotionMenus");
            String str2 = paramStructMsgNode.a("promotionMenuDestructiveIndex");
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
            this.source_puin = paramStructMsgNode.a("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = paramStructMsgNode.a("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = paramStructMsgNode.a("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = paramStructMsgNode.a("sType");
              str1 = paramStructMsgNode.a("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                str1 = paramStructMsgNode.a("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = paramStructMsgNode.a("adverKey");
                  this.index = paramStructMsgNode.a("index");
                  this.index_name = paramStructMsgNode.a("index_name");
                  this.index_type = paramStructMsgNode.a("index_type");
                  this.mExtraData = paramStructMsgNode.a("extraData");
                  this.mCreateTime = paramStructMsgNode.a("createTime");
                  this.mTagName = paramStructMsgNode.a("tagName");
                  this.mArticleIds = paramStructMsgNode.a("articleIds");
                  this.mOrangeWord = paramStructMsgNode.a("orangeWord");
                  this.mAlgorithmIds = paramStructMsgNode.a("algorithmIds");
                  this.mStrategyIds = paramStructMsgNode.a("strategyIds");
                  this.reportEventFolderStatusValue = paramStructMsgNode.a("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = paramStructMsgNode.a("qf_task_id");
                  this.mInnerUniqIds = paramStructMsgNode.a("uuids");
                  this.mQQStoryExtra = paramStructMsgNode.a("qqstoryExtra");
                  this.mTribeShortVideoExtra = paramStructMsgNode.a("qqtribeVideoInfoExtra");
                  this.mNeedRound = paramStructMsgNode.a("needRoundView");
                  this.mCommonData = paramStructMsgNode.a("msgCommonData");
                  this.mMergeSeq = paramStructMsgNode.a("mergeSeq");
                  paramStructMsgNode = paramStructMsgNode.a("sortKey");
                  try
                  {
                    if (!TextUtils.isEmpty(paramStructMsgNode)) {
                      this.mSortKey = Long.parseLong(paramStructMsgNode);
                    }
                    if (((this.mMsgServiceID != 142) && (this.mMsgServiceID != 500)) || (!TextUtils.isEmpty(this.mExtraData)) || (TextUtils.isEmpty(this.mMsgActionData))) {
                      continue;
                    }
                    try
                    {
                      this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
                      return;
                    }
                    catch (Exception paramStructMsgNode)
                    {
                      paramStructMsgNode.getStackTrace();
                      return;
                    }
                  }
                  catch (NumberFormatException paramStructMsgNode)
                  {
                    for (;;)
                    {
                      paramStructMsgNode.printStackTrace();
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