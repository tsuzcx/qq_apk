import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import java.util.Comparator;

public class nea
  implements Comparator
{
  public nea(MsgTabNodeInsertLocalVideoInfoSegment paramMsgTabNodeInsertLocalVideoInfoSegment) {}
  
  public int a(MsgTabVideoData paramMsgTabVideoData1, MsgTabVideoData paramMsgTabVideoData2)
  {
    return MsgTabStoryUtil.a(paramMsgTabVideoData1.a.mCreateTime, paramMsgTabVideoData2.a.mCreateTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nea
 * JD-Core Version:    0.7.0.1
 */