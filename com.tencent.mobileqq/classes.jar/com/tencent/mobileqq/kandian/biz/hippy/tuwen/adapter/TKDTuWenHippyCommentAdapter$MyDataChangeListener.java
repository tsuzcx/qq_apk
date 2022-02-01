package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.util.Pair;
import java.util.List;
import org.json.JSONObject;

class TKDTuWenHippyCommentAdapter$MyDataChangeListener
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  private TKDTuWenHippyCommentAdapter$MyDataChangeListener(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  private String prepareSubCommentData(SubCommentData paramSubCommentData)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("commentId", paramSubCommentData.commentId);
      localJSONObject.put("nickName", paramSubCommentData.nickName);
      localJSONObject.put("isAuthorReply", paramSubCommentData.isAuthorReply);
      localJSONObject.put("followStatus", paramSubCommentData.isFollowing);
      localJSONObject.put("repliedUserId", paramSubCommentData.repliedUserUin);
      localJSONObject.put("repliedUserNickName", paramSubCommentData.repliedUserNickname);
      localJSONObject.put("repliedUserHomepage", paramSubCommentData.repliedUserHomePage);
      localJSONObject.put("authorLike", paramSubCommentData.isAuthorLike);
      localJSONObject.put("content", paramSubCommentData.getWholeStringContent());
      paramSubCommentData = localJSONObject.toString();
      return paramSubCommentData;
    }
    catch (Exception paramSubCommentData)
    {
      label114:
      break label114;
    }
    return "";
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, CommentViewItem paramCommentViewItem, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, CommentViewItem paramCommentViewItem, boolean paramBoolean2, List<CommentViewItem> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, CommentViewItem paramCommentViewItem, int paramInt2)
  {
    if ((paramBoolean) && (paramCommentViewItem != null))
    {
      Object localObject = paramCommentViewItem.c;
      if (localObject != null)
      {
        paramCommentViewItem = ((BaseCommentData)localObject).commentId;
        if ((localObject instanceof SubCommentData))
        {
          localObject = ((SubCommentData)localObject).parentCommentId;
          TKDTuWenHippyCommentAdapter.access$1300(this.this$0, (String)localObject, paramCommentViewItem);
          return;
        }
        TKDTuWenHippyCommentAdapter.access$1200(this.this$0, paramCommentViewItem);
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (paramInt1 == 0) && ((paramBaseCommentData instanceof CommentData)))
    {
      paramBoolean = true;
      if (paramInt2 != 1) {
        paramBoolean = false;
      }
      TKDTuWenHippyCommentAdapter.access$1000(this.this$0, paramBaseCommentData.commentId, paramBoolean);
    }
  }
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2) {}
  
  public void onCommentReply(boolean paramBoolean, CommentViewItem paramCommentViewItem)
  {
    if ((paramBoolean) && (paramCommentViewItem != null))
    {
      paramCommentViewItem = paramCommentViewItem.c;
      if ((paramCommentViewItem != null) && ((paramCommentViewItem instanceof SubCommentData)))
      {
        paramCommentViewItem = (SubCommentData)paramCommentViewItem;
        String str1 = paramCommentViewItem.parentCommentId;
        String str2 = paramCommentViewItem.repliedCommentId;
        TKDTuWenHippyCommentAdapter.access$1100(this.this$0, str1, str2, prepareSubCommentData(paramCommentViewItem));
      }
    }
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.MyDataChangeListener
 * JD-Core Version:    0.7.0.1
 */