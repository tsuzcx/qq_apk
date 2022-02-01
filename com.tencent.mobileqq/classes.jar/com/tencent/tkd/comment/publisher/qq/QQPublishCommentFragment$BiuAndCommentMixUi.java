package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQLog;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQSharedPreferences;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQView;
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
    this.vBiuAndCommentMixDeliverLayout = ((RelativeLayout)paramDialog.findViewById(2131363624));
    this.vBiuAndCommentMixWordingLayout = ((RelativeLayout)paramDialog.findViewById(2131363627));
    this.vBiuAndCommentMixCheckBoxLayout = ((LinearLayout)paramDialog.findViewById(2131363621));
    this.vBiuAndCommentMixWordingText = ((TextView)paramDialog.findViewById(2131363628));
    this.vBiuAndCommentMixSelectToFriendImg = ((ImageView)paramDialog.findViewById(2131363623));
    this.vBiuAndCommentMixDeliverButton = ((Button)paramDialog.findViewById(2131363622));
    this.vBiuAndCommentMixCheckBoxText = ((TextView)paramDialog.findViewById(2131363625));
  }
  
  private void biuAndCommentDeliver()
  {
    reportMixCommentBiuBtnClick();
    if (!QQPublishCommentFragment.access$2500(this.this$0)) {
      return;
    }
    if (QQPublishCommentFragment.access$1200(this.this$0).editorDefaultEnableRemember) {
      TkdQQSharedPreferences.setValue("rij_sp_editor_last_check", Boolean.valueOf(this.isSelectedToFriend));
    }
    TkdQQView.onDelieverBiu(getBiuAndCommentIntent());
    QQPublishCommentFragment.access$2602(this.this$0, true);
    this.this$0.dismissAllowingStateLoss();
  }
  
  private void changeGuideWording()
  {
    this.wordingNum += 1;
    if ((this.guideWordingList != null) && (this.guideWordingList.length != 0))
    {
      if (this.wordingNum >= this.guideWordingList.length) {
        this.wordingNum = 0;
      }
      this.vBiuAndCommentMixWordingText.setText(this.guideWordingList[this.wordingNum]);
    }
  }
  
  /* Error */
  private String getBiuAndCommentIntent()
  {
    // Byte code:
    //   0: new 140	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   8: invokestatic 144	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$2700	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Ljava/lang/String;
    //   11: invokevirtual 148	java/lang/String:getBytes	()[B
    //   14: iconst_0
    //   15: invokestatic 154	android/util/Base64:encode	([BI)[B
    //   18: invokespecial 157	java/lang/String:<init>	([B)V
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   26: invokestatic 160	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$2800	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Ljava/lang/String;
    //   29: astore_2
    //   30: new 162	org/json/JSONObject
    //   33: dup
    //   34: invokespecial 163	org/json/JSONObject:<init>	()V
    //   37: astore_1
    //   38: aload_2
    //   39: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +179 -> 221
    //   45: new 162	org/json/JSONObject
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   60: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   63: getfield 174	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:isNativeCommentComponet	Z
    //   66: ifeq +81 -> 147
    //   69: aload_0
    //   70: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   73: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   76: getfield 178	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:isSecondCommentReplyUin	Ljava/lang/String;
    //   79: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifeq +113 -> 195
    //   85: ldc 180
    //   87: astore_2
    //   88: aload_1
    //   89: ldc 182
    //   91: aload_2
    //   92: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc 188
    //   99: aload_0
    //   100: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   103: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   106: getfield 191	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:isSecondCommentReply	Z
    //   109: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_1
    //   114: ldc 196
    //   116: aload_0
    //   117: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   120: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   123: getfield 198	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:commentId	Ljava/lang/String;
    //   126: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload_1
    //   131: ldc 200
    //   133: aload_0
    //   134: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   137: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   140: getfield 203	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:mCommentAuthorUin	Ljava/lang/String;
    //   143: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload_1
    //   148: ldc 205
    //   150: aload_3
    //   151: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   154: pop
    //   155: aload_1
    //   156: ldc 207
    //   158: aload_0
    //   159: getfield 98	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:isSelectedToFriend	Z
    //   162: invokevirtual 194	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   165: pop
    //   166: ldc 209
    //   168: new 211	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   175: ldc 214
    //   177: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 230	com/tencent/tkd/comment/publisher/qq/util/TkdQQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_1
    //   191: invokevirtual 231	org/json/JSONObject:toString	()Ljava/lang/String;
    //   194: areturn
    //   195: aload_0
    //   196: getfield 32	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment$BiuAndCommentMixUi:this$0	Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;
    //   199: invokestatic 89	com/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment:access$1200	(Lcom/tencent/tkd/comment/publisher/qq/QQPublishCommentFragment;)Lcom/tencent/tkd/comment/publisher/qq/model/TkdQQArgument;
    //   202: getfield 178	com/tencent/tkd/comment/publisher/qq/model/TkdQQArgument:isSecondCommentReplyUin	Ljava/lang/String;
    //   205: astore_2
    //   206: goto -118 -> 88
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 234	org/json/JSONException:printStackTrace	()V
    //   214: goto -48 -> 166
    //   217: astore_2
    //   218: goto -8 -> 210
    //   221: goto -165 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	BiuAndCommentMixUi
    //   37	154	1	localObject1	Object
    //   29	177	2	localObject2	Object
    //   209	2	2	localJSONException1	JSONException
    //   217	1	2	localJSONException2	JSONException
    //   21	130	3	str	String
    // Exception table:
    //   from	to	target	type
    //   38	54	209	org/json/JSONException
    //   56	85	217	org/json/JSONException
    //   88	147	217	org/json/JSONException
    //   147	166	217	org/json/JSONException
    //   195	206	217	org/json/JSONException
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
    if (QQPublishCommentFragment.access$1200(this.this$0).biuEditorCheckBoxHidden) {
      this.vBiuAndCommentMixCheckBoxLayout.setVisibility(8);
    }
    do
    {
      return;
      this.vBiuAndCommentMixCheckBoxLayout.setVisibility(0);
      str = QQPublishCommentFragment.access$1200(this.this$0).biuEditorCheckBoxWording;
      if (!TextUtils.isEmpty(str)) {
        this.vBiuAndCommentMixCheckBoxText.setText(str);
      }
      if (QQPublishCommentFragment.access$1200(this.this$0).biuEditorDefaultStatus) {
        setCheckBoxCheck(true);
      }
    } while (!QQPublishCommentFragment.access$1200(this.this$0).editorDefaultEnableRemember);
    setCheckBoxCheck(((Boolean)TkdQQSharedPreferences.getValue("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue());
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
      TkdQQLog.d("QQPublisherFragment", "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", TkdQQReport.getReportVersion());
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    TkdQQReport.publicAccountReportClickEvent(QQPublishCommentFragment.access$1300(this.this$0), "0X800AB7B", "0X800AB7B", String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mArticleID), String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mSourceType), QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.innerUniqueID, (String)localObject1);
  }
  
  private void reportMixCommentBiuBtnExposure()
  {
    if (QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo == null)
    {
      TkdQQLog.d("QQPublisherFragment", "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", TkdQQReport.getReportVersion());
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    TkdQQReport.publicAccountReportClickEvent(QQPublishCommentFragment.access$1300(this.this$0), "0X800AB7A", "0X800AB7A", String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.mArticleID), String.valueOf(QQPublishCommentFragment.access$1200(this.this$0).mSourceType), QQPublishCommentFragment.access$1200(this.this$0).mArticleInfo.innerUniqueID, (String)localObject1);
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
      TkdQQLog.d("QQPublisherFragment", "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return false;
    }
    initBiuAndCommentMixView();
    setBiuAndCommentClickListener();
    reportMixCommentBiuBtnExposure();
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (paramView == this.vBiuAndCommentMixCheckBoxLayout) {
      if (!this.isSelectedToFriend)
      {
        bool = true;
        setCheckBoxCheck(bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      if (paramView == this.vBiuAndCommentMixDeliverButton) {
        biuAndCommentDeliver();
      } else if (paramView == this.vBiuAndCommentMixWordingText) {
        changeGuideWording();
      }
    }
  }
  
  void onUpdateDeliverEnable(boolean paramBoolean)
  {
    this.vBiuAndCommentMixDeliverButton.setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.BiuAndCommentMixUi
 * JD-Core Version:    0.7.0.1
 */