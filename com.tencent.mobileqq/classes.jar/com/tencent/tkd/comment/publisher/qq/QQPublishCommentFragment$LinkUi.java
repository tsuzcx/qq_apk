package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQView;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView.OnLinkDeleteLinstener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class QQPublishCommentFragment$LinkUi
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, TkdCommentLinkView.OnLinkDeleteLinstener
{
  private int linkCount;
  private final TkdCommentLinkView vCommentLink;
  final View vCommentLinkDivider;
  private final FrameLayout vCommentLinkLayout;
  private final ImageView vLinkBtn;
  
  QQPublishCommentFragment$LinkUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vLinkBtn = ((ImageView)paramDialog.findViewById(2131370161));
    this.vLinkBtn.setOnClickListener(this);
    this.vCommentLinkLayout = ((FrameLayout)paramDialog.findViewById(2131370171));
    this.vCommentLinkDivider = paramDialog.findViewById(2131370167);
    this.vCommentLinkLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.vCommentLink = ((TkdCommentLinkView)paramDialog.findViewById(2131364950));
    this.vCommentLink.setLinkDeleteLinstener(this);
  }
  
  private void checkShowDivider()
  {
    View localView = this.vCommentLinkDivider;
    if (this.linkCount > 0) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private String getLinkR5Data()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", 1);
      localJSONObject.put("entry", TkdQQReport.getEntry());
      localJSONObject.put("comment_level", TkdQQReport.getCommentLevel());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void openLink()
  {
    TkdQQView.openLink(this.vCommentLinkLayout);
    TkdQQReport.publicAccountReportClickEvent(QQPublishCommentFragment.access$1300(this.this$0), "0X800B085", "0X800B085", "", "", "", getLinkR5Data());
  }
  
  private void reportDeleteLinkIfNeed(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      TkdQQReport.publicAccountReportClickEvent(QQPublishCommentFragment.access$1300(this.this$0), "0X800B086", "0X800B086", "", "", "", getLinkR5Data());
    }
  }
  
  void initData()
  {
    ImageView localImageView = this.vLinkBtn;
    if (QQPublishCommentFragment.access$1200(this.this$0).showLink) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  void onAddLink(TkdCommentLinkData paramTkdCommentLinkData)
  {
    this.vCommentLink.addData(paramTkdCommentLinkData);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vLinkBtn) {
      openLink();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDeleteLink() {}
  
  void onDestroy()
  {
    this.vCommentLinkLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    View localView = this.vCommentLinkLayout.getChildAt(0);
    if ((localView instanceof ViewGroup)) {}
    for (int i = ((ViewGroup)localView).getChildCount();; i = 0)
    {
      reportDeleteLinkIfNeed(this.linkCount, i);
      this.linkCount = i;
      checkShowDivider();
      return;
    }
  }
  
  void packageDataInfo(JSONObject paramJSONObject)
  {
    List localList = this.vCommentLink.getData();
    if ((localList != null) && (!localList.isEmpty())) {
      paramJSONObject.put("linkList", new JSONArray(new Gson().toJson(localList)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.LinkUi
 * JD-Core Version:    0.7.0.1
 */