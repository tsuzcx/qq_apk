package cooperation.qzone.contentbox;

import NS_MOBILE_DROPLIST.mobile_video_nag_feedback_req;
import NS_MOBILE_DROPLIST.nagative_fb_info;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;

public class QZoneMsgNegativeRequest
  extends QZoneCommonRequest
{
  private static final String CMD = "videoNagFeedback";
  public JceStruct req;
  private int type;
  
  public QZoneMsgNegativeRequest(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject = new nagative_fb_info();
    ((nagative_fb_info)localObject).fb_type = paramInt1;
    ((nagative_fb_info)localObject).tag_type = paramInt2;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new mobile_video_nag_feedback_req();
    ((mobile_video_nag_feedback_req)localObject).loginUin = paramLong2;
    ((mobile_video_nag_feedback_req)localObject).feedsUin = paramLong1;
    ((mobile_video_nag_feedback_req)localObject).vecNagFbInfo = localArrayList;
    this.req = ((JceStruct)localObject);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.Operation.videoNagFeedback";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String uniKey()
  {
    return "videoNagFeedback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgNegativeRequest
 * JD-Core Version:    0.7.0.1
 */