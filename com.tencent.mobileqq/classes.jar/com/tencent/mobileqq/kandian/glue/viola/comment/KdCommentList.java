package com.tencent.mobileqq.kandian.glue.viola.comment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper.ISecondCommentViewStateListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.OnCreateViewListener;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.util.Pair;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KdCommentList
  extends VDiv
  implements ReadInJoyCommentHelper.ISecondCommentViewStateListener, ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener, ReadInJoyCommentListFragment.OnCreateViewListener, ReadInJoyCommentDataManager.OnDataChangeListener
{
  public static final String EVENT_CHANGE = "change";
  public static final String EVENT_COMMENT_CHANGE = "commentChange";
  public static final String EVENT_SCROLL_CHANGE = "scrollChange";
  private KdCommentHeaderView kdHeaderView;
  private ReadInJoyCommentListFragment readInJoyCommentListFragment;
  
  public KdCommentList(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void fireCommentListEvent(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    if (this.mDomObj != null)
    {
      localJSONArray.put(this.mDomObj.getRef());
      localJSONArray.put("change");
    }
    fireEvent("change", localJSONArray, paramJSONObject);
  }
  
  private JSONObject getJSONObjectFromAttr(String paramString)
  {
    DomObject localDomObject = getDomObject();
    if (localDomObject == null) {
      return null;
    }
    paramString = localDomObject.getAttributes().get(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  private JSONObject mergeSrcToConfig(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null)) {
      return new JSONObject();
    }
    if (paramJSONObject1 == null) {
      return paramJSONObject2;
    }
    if (paramJSONObject2 == null) {
      return paramJSONObject1;
    }
    Iterator localIterator = paramJSONObject1.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject2.put(str, paramJSONObject1.opt(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return paramJSONObject2;
  }
  
  public void addSubView(View paramView, int paramInt)
  {
    if ((paramView instanceof KdCommentHeaderView)) {
      this.kdHeaderView = ((KdCommentHeaderView)paramView);
    }
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramView != null) {
      paramVComponent = paramView.getLayoutParams();
    } else {
      paramVComponent = null;
    }
    if (paramVComponent == null) {
      return new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    paramVComponent.width = paramInt1;
    paramVComponent.height = paramInt2;
    return paramVComponent;
  }
  
  public void notifyParentWhenChildAddEnd()
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    JSONObject localJSONObject1 = getJSONObjectFromAttr("src");
    JSONObject localJSONObject2 = getJSONObjectFromAttr("config");
    if (localJSONObject1 != null)
    {
      if (localJSONObject2 == null) {
        return;
      }
      localView.post(new KdCommentList.1(this, localJSONObject1, localJSONObject2, localView));
    }
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    RIJCommentResultDispatcher.a().b(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.readInJoyCommentListFragment;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    if (paramBoolean)
    {
      paramCommentViewItem = new JSONObject();
      try
      {
        paramCommentViewItem.put("commentChange", 1);
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
      fireCommentListEvent(paramCommentViewItem);
    }
  }
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    if (paramBoolean)
    {
      paramCommentViewItem = new JSONObject();
      try
      {
        paramCommentViewItem.put("commentChange", -1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      fireCommentListEvent(paramCommentViewItem);
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2) {}
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem) {}
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onCommentStateError(int paramInt) {}
  
  public void onScroll(int paramInt)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scrollChange", FlexConvertUtils.px2dip(paramInt));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    fireCommentListEvent(localJSONObject);
  }
  
  public void onViewCreated(boolean paramBoolean)
  {
    Object localObject = this.readInJoyCommentListFragment;
    if (localObject == null) {
      return;
    }
    localObject = ((ReadInJoyCommentListFragment)localObject).d();
    if (localObject == null) {
      return;
    }
    this.readInJoyCommentListFragment.a(this);
    this.readInJoyCommentListFragment.a(this);
    this.readInJoyCommentListFragment.e();
    ((ListView)localObject).addHeaderView(this.kdHeaderView);
    localObject = this.kdHeaderView.getComponent();
    if (localObject != null)
    {
      ((VDiv)localObject).applyLayout();
      ((VDiv)localObject).applyEvents();
      ((VDiv)localObject).bindData();
    }
  }
  
  public void onViewState(boolean paramBoolean, String paramString)
  {
    if (!this.mAppendEvents.contains("change")) {
      return;
    }
    try
    {
      fireCommentListEvent(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentList
 * JD-Core Version:    0.7.0.1
 */