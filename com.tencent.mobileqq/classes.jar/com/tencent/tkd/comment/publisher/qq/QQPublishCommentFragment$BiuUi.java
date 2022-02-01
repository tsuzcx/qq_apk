package com.tencent.tkd.comment.publisher.qq;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQToast;
import org.json.JSONObject;

class QQPublishCommentFragment$BiuUi
  implements View.OnClickListener, QQPublishCommentFragment.OnGifChangeListener
{
  private boolean hasPicData;
  boolean isSelected;
  private final ImageView vBiuImageView;
  private final LinearLayout vBiuLayout;
  
  QQPublishCommentFragment$BiuUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vBiuImageView = ((ImageView)paramDialog.findViewById(2131365055));
    this.vBiuLayout = ((LinearLayout)paramDialog.findViewById(2131363722));
    this.vBiuLayout.setVisibility(8);
  }
  
  private void onBiuButton()
  {
    if (this.hasPicData)
    {
      TkdQQToast.show(this.this$0.getActivity().getString(2131719924), 0);
      return;
    }
    if (!this.isSelected) {
      this.vBiuImageView.setImageResource(2130851083);
    }
    for (this.isSelected = true;; this.isSelected = false)
    {
      reportClickBiu();
      return;
      this.vBiuImageView.setImageResource(2130851082);
    }
  }
  
  private void reportClickBiu()
  {
    if (this.isSelected) {}
    for (String str = "0";; str = "1")
    {
      TkdQQReport.publicAccountReportClickEvent("", "0X8008F58", "0X8008F58", str, "", "", QQPublishCommentFragment.access$1800(this.this$0, false));
      return;
    }
  }
  
  void hide()
  {
    this.vBiuLayout.setVisibility(8);
  }
  
  void initData()
  {
    if (!QQPublishCommentFragment.access$1200(this.this$0).showBiu) {}
    do
    {
      return;
      this.vBiuLayout.setVisibility(0);
      this.vBiuLayout.setOnClickListener(this);
    } while (!QQPublishCommentFragment.access$1200(this.this$0).selectBiu);
    this.vBiuImageView.setImageResource(2130851083);
    this.isSelected = true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vBiuLayout) {
      onBiuButton();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onGifDelete(boolean paramBoolean)
  {
    this.hasPicData = false;
    this.vBiuImageView.setClickable(true);
    if (paramBoolean) {
      this.vBiuImageView.setImageResource(2130851083);
    }
  }
  
  public boolean onGifSelected()
  {
    this.hasPicData = true;
    if (this.isSelected) {
      this.vBiuImageView.setImageResource(2130851082);
    }
    return this.isSelected;
  }
  
  void packageDataInfo(JSONObject paramJSONObject)
  {
    int i = 0;
    if (this.hasPicData) {
      paramJSONObject.put("biuAfterComment", 0);
    }
    for (;;)
    {
      if (this.isSelected)
      {
        JSONObject localJSONObject = QQPublishCommentManager.getInstance().getPublisherBridge().buildArticleBiuCommentInfo(QQPublishCommentFragment.access$300(this.this$0).getText());
        if (localJSONObject != null) {
          paramJSONObject.put("biu_info", localJSONObject);
        }
      }
      return;
      if (this.isSelected) {
        i = 1;
      }
      paramJSONObject.put("biuAfterComment", i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.BiuUi
 * JD-Core Version:    0.7.0.1
 */