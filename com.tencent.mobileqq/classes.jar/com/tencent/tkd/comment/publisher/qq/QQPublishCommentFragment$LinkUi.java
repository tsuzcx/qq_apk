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
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
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
    this.vLinkBtn = ((ImageView)paramDialog.findViewById(R.id.x));
    this.vLinkBtn.setOnClickListener(this);
    this.vCommentLinkLayout = ((FrameLayout)paramDialog.findViewById(R.id.z));
    this.vCommentLinkDivider = paramDialog.findViewById(R.id.y);
    this.vCommentLinkLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.vCommentLink = ((TkdCommentLinkView)paramDialog.findViewById(R.id.l));
    this.vCommentLink.setLinkDeleteLinstener(this);
    this.vCommentLink.urlImageBridge = paramQQPublishCommentFragment.urlImageBridge;
  }
  
  private void checkShowDivider()
  {
    View localView = this.vCommentLinkDivider;
    int i;
    if (this.linkCount > 0) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private String getLinkR5Data()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", 1);
      localJSONObject.put("entry", this.this$0.reportBridge.getEntry());
      localJSONObject.put("comment_level", this.this$0.reportBridge.getCommentLevel());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private void openLink()
  {
    this.this$0.viewBridge.openLink(this.vCommentLinkLayout);
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, QQPublishCommentFragment.access$1300(localQQPublishCommentFragment), "0X800B085", "0X800B085", "", "", "", getLinkR5Data());
  }
  
  private void reportDeleteLinkIfNeed(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
      QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, QQPublishCommentFragment.access$1300(localQQPublishCommentFragment), "0X800B086", "0X800B086", "", "", "", getLinkR5Data());
    }
  }
  
  void initData()
  {
    ImageView localImageView = this.vLinkBtn;
    int i;
    if (QQPublishCommentFragment.access$1200(this.this$0).showLink) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
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
  }
  
  public void onDeleteLink()
  {
    this.this$0.viewBridge.onDeleteLink();
  }
  
  void onDestroy()
  {
    this.vCommentLinkLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    Object localObject = this.vCommentLinkLayout;
    int i = 0;
    localObject = ((FrameLayout)localObject).getChildAt(0);
    if ((localObject instanceof ViewGroup)) {
      i = ((ViewGroup)localObject).getChildCount();
    }
    reportDeleteLinkIfNeed(this.linkCount, i);
    this.linkCount = i;
    checkShowDivider();
  }
  
  void packageDataInfo(JSONObject paramJSONObject)
  {
    List localList = this.vCommentLink.getData();
    if ((localList != null) && (!localList.isEmpty())) {
      paramJSONObject.put("linkList", new JSONArray(new Gson().toJson(localList)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.LinkUi
 * JD-Core Version:    0.7.0.1
 */