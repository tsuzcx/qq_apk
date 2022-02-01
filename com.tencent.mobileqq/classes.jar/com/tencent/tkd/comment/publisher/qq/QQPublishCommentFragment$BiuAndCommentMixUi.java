package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLogBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class QQPublishCommentFragment$BiuAndCommentMixUi
  implements View.OnClickListener
{
  private String[] guideWordingList;
  private boolean isBiuAndCommentMixType;
  private boolean isNewCommentComponentType = true;
  private boolean isSelectedToFriend;
  private final LinearLayout vBiuAndCommentMixCheckBoxLayout;
  private final TextView vBiuAndCommentMixCheckBoxText;
  private final Button vBiuAndCommentMixDeliverButton;
  private final RelativeLayout vBiuAndCommentMixDeliverLayout;
  private final ImageView vBiuAndCommentMixSelectToFriendImg;
  private final RelativeLayout vBiuAndCommentMixWordingLayout;
  private final TextView vBiuAndCommentMixWordingText;
  private int wordingNum;
  
  QQPublishCommentFragment$BiuAndCommentMixUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vBiuAndCommentMixDeliverLayout = ((RelativeLayout)paramDialog.findViewById(R.id.e));
    this.vBiuAndCommentMixWordingLayout = ((RelativeLayout)paramDialog.findViewById(R.id.g));
    this.vBiuAndCommentMixCheckBoxLayout = ((LinearLayout)paramDialog.findViewById(R.id.b));
    this.vBiuAndCommentMixWordingText = ((TextView)paramDialog.findViewById(R.id.h));
    this.vBiuAndCommentMixSelectToFriendImg = ((ImageView)paramDialog.findViewById(R.id.d));
    this.vBiuAndCommentMixDeliverButton = ((Button)paramDialog.findViewById(R.id.c));
    this.vBiuAndCommentMixCheckBoxText = ((TextView)paramDialog.findViewById(R.id.f));
  }
  
  private void biuAndCommentDeliver()
  {
    reportMixCommentBiuBtnClick();
    if (!QQPublishCommentFragment.access$2600(this.this$0)) {
      return;
    }
    if (QQPublishCommentFragment.access$1200(this.this$0).editorDefaultEnableRemember) {
      this.this$0.sharedPreferenceBridge.setValue("rij_sp_editor_last_check", Boolean.valueOf(this.isSelectedToFriend));
    }
    this.this$0.viewBridge.onDelieverBiu(getBiuAndCommentIntent());
    QQPublishCommentFragment.access$2702(this.this$0, true);
    this.this$0.dismissAllowingStateLoss();
  }
  
  private void changeGuideWording()
  {
    this.wordingNum += 1;
    String[] arrayOfString = this.guideWordingList;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      if (this.wordingNum >= arrayOfString.length) {
        this.wordingNum = 0;
      }
      this.vBiuAndCommentMixWordingText.setText(this.guideWordingList[this.wordingNum]);
    }
  }
  
  private String getBiuAndCommentIntent()
  {
    String str1 = new String(Base64.encode(QQPublishCommentFragment.access$2800(this.this$0).getBytes(), 0));
    String str2 = QQPublishCommentFragment.access$2900(this.this$0);
    Object localObject4 = new JSONObject();
    Object localObject1 = localObject4;
    Object localObject3 = localObject4;
    Object localObject2;
    try
    {
      if (!TextUtils.isEmpty(str2))
      {
        localObject3 = localObject4;
        localObject1 = new JSONObject(str2);
      }
      localObject3 = localObject1;
      if (QQPublishCommentFragment.access$1200(this.this$0).isNativeCommentComponet)
      {
        localObject3 = localObject1;
        if (TextUtils.isEmpty(QQPublishCommentFragment.access$1200(this.this$0).isSecondCommentReplyUin))
        {
          localObject4 = "";
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = QQPublishCommentFragment.access$1200(this.this$0).isSecondCommentReplyUin;
        }
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("replyUin", localObject4);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("isSecondReply", QQPublishCommentFragment.access$1200(this.this$0).isSecondCommentReply);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentId", QQPublishCommentFragment.access$1200(this.this$0).commentId);
        localObject3 = localObject1;
        ((JSONObject)localObject1).put("commentUin", QQPublishCommentFragment.access$1200(this.this$0).mCommentAuthorUin);
      }
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("comment", str1);
      localObject3 = localObject1;
      ((JSONObject)localObject1).put("select_to_friend", this.isSelectedToFriend);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = localObject3;
    }
    localObject3 = this.this$0.logBridge;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("showCommentEditorNew getBiuAndCommentIntent result json is ");
    ((StringBuilder)localObject4).append(localObject2);
    ((QQLogBridge)localObject3).d("QQPublisherFragment", ((StringBuilder)localObject4).toString());
    return localObject2.toString();
  }
  
  private void initAladdinSetting()
  {
    this.guideWordingList = QQPublishCommentFragment.access$1200(this.this$0).biuEditorGuideWording.split("\\|");
    if (this.guideWordingList.length > 0) {
      this.wordingNum = new Random().nextInt(this.guideWordingList.length);
    }
    if (!TextUtils.isEmpty(this.guideWordingList[this.wordingNum])) {
      this.vBiuAndCommentMixWordingText.setText(this.guideWordingList[this.wordingNum]);
    }
    String str = QQPublishCommentFragment.access$1200(this.this$0).biuEditorConfirmBtnWording;
    if (!TextUtils.isEmpty(str)) {
      this.vBiuAndCommentMixDeliverButton.setText(str);
    }
    if (QQPublishCommentFragment.access$1200(this.this$0).biuEditorCheckBoxHidden)
    {
      this.vBiuAndCommentMixCheckBoxLayout.setVisibility(8);
      return;
    }
    this.vBiuAndCommentMixCheckBoxLayout.setVisibility(0);
    str = QQPublishCommentFragment.access$1200(this.this$0).biuEditorCheckBoxWording;
    if (!TextUtils.isEmpty(str)) {
      this.vBiuAndCommentMixCheckBoxText.setText(str);
    }
    if (QQPublishCommentFragment.access$1200(this.this$0).biuEditorDefaultStatus) {
      setCheckBoxCheck(true);
    }
    if (QQPublishCommentFragment.access$1200(this.this$0).editorDefaultEnableRemember) {
      setCheckBoxCheck(((Boolean)this.this$0.sharedPreferenceBridge.getValue("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue());
    }
  }
  
  private void initBiuAndCommentMixView()
  {
    this.vBiuAndCommentMixDeliverLayout.setVisibility(0);
    if (TextUtils.isEmpty(QQPublishCommentFragment.access$1200(this.this$0).mParentCommentAuthorUin)) {
      this.vBiuAndCommentMixWordingLayout.setVisibility(0);
    }
    initAladdinSetting();
  }
  
  private void reportMixCommentBiuBtnClick()
  {
    if (QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo == null)
    {
      this.this$0.logBridge.d("QQPublisherFragment", "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedType);
      ((JSONObject)localObject).put("feedsid", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedId);
      ((JSONObject)localObject).put("version", this.this$0.reportBridge.getReportVersion());
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("entry", 1);
      ((JSONObject)localObject).put("place", 1);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      str = "";
    }
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, QQPublishCommentFragment.access$1300(localQQPublishCommentFragment), "0X800AB7B", "0X800AB7B", String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mArticleID), String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mSourceType), QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.innerUniqueID, str);
  }
  
  private void reportMixCommentBiuBtnExposure()
  {
    if (QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo == null)
    {
      this.this$0.logBridge.d("QQPublisherFragment", "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_type", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedType);
      ((JSONObject)localObject).put("feedsid", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedId);
      ((JSONObject)localObject).put("version", this.this$0.reportBridge.getReportVersion());
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("entry", 1);
      ((JSONObject)localObject).put("place", 1);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      str = "";
    }
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, QQPublishCommentFragment.access$1300(localQQPublishCommentFragment), "0X800AB7A", "0X800AB7A", String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mArticleID), String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mSourceType), QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.innerUniqueID, str);
  }
  
  private void setBiuAndCommentClickListener()
  {
    this.vBiuAndCommentMixCheckBoxLayout.setOnClickListener(this);
    this.vBiuAndCommentMixDeliverButton.setOnClickListener(this);
    this.vBiuAndCommentMixWordingText.setOnClickListener(this);
  }
  
  private void setCheckBoxCheck(boolean paramBoolean)
  {
    this.vBiuAndCommentMixSelectToFriendImg.setSelected(paramBoolean);
    this.isSelectedToFriend = paramBoolean;
  }
  
  boolean initBiuAndCommentMix()
  {
    this.isNewCommentComponentType = QQPublishCommentFragment.access$1200(this.this$0).isNewCommentComponentType;
    if ((QQPublishCommentFragment.access$1200(this.this$0).biuAndCommentSwitch) && (this.isNewCommentComponentType)) {
      this.isBiuAndCommentMixType = true;
    }
    if (!this.isBiuAndCommentMixType)
    {
      this.this$0.logBridge.d("QQPublisherFragment", "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return false;
    }
    initBiuAndCommentMixView();
    setBiuAndCommentClickListener();
    reportMixCommentBiuBtnExposure();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vBiuAndCommentMixCheckBoxLayout)
    {
      setCheckBoxCheck(this.isSelectedToFriend ^ true);
      return;
    }
    if (paramView == this.vBiuAndCommentMixDeliverButton)
    {
      biuAndCommentDeliver();
      return;
    }
    if (paramView == this.vBiuAndCommentMixWordingText) {
      changeGuideWording();
    }
  }
  
  void onUpdateDeliverEnable(boolean paramBoolean)
  {
    this.vBiuAndCommentMixDeliverButton.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.BiuAndCommentMixUi
 * JD-Core Version:    0.7.0.1
 */