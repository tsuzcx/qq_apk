package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class QCircleTaskReportInfo
  implements Serializable
{
  public String albumId;
  public long author_uin;
  public int backendPicHeight;
  public long backendPicSize;
  public int backendPicWidth;
  public String city_name;
  public long client_compress_mediaBitrate;
  public int client_compress_pic_height;
  public long client_compress_pic_size;
  public int client_compress_pic_width;
  public String country_name;
  public int edited_pic_height;
  public long edited_pic_size;
  public int edited_pic_width;
  public long edited_video_mediaBitrate;
  public String feed_tag;
  public String feedid;
  public boolean hasCompress;
  public int is_video;
  public String lloc;
  public long mediaOriginBitrate;
  public int origPicHeight;
  public long origPicSize;
  public int origPicWidth;
  public String picture_format;
  public String place;
  public String place_name;
  public String prov_name;
  public String shoot_model;
  public String shoot_place;
  public String shoot_product;
  public String shooting_time;
  public int total_upload_num;
  public String traceId;
  public String txtinfo;
  public String up_place;
  public int up_source;
  public int up_type;
  public String vid;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("QCircleTaskReportInfo{\n");
    localStringBuffer.append("up_source=").append(this.up_source).append('\n');
    localStringBuffer.append(", up_type=").append(this.up_type).append('\n');
    localStringBuffer.append(", is_video=").append(this.is_video).append('\n');
    localStringBuffer.append(", txtinfo='").append(this.txtinfo).append('\'').append('\n');
    localStringBuffer.append(", lloc='").append(this.lloc).append('\'').append('\n');
    localStringBuffer.append(", vid='").append(this.vid).append('\'').append('\n');
    localStringBuffer.append(", feedid='").append(this.feedid).append('\'').append('\n');
    localStringBuffer.append(", total_upload_num=").append(this.total_upload_num).append('\n');
    localStringBuffer.append(", shooting_time='").append(this.shooting_time).append('\'').append('\n');
    if (QLog.isColorLevel())
    {
      localStringBuffer.append(", place='").append(this.place).append('\'').append('\n');
      localStringBuffer.append(", up_place='").append(this.up_place).append('\'').append('\n');
      localStringBuffer.append(", shoot_product='").append(this.shoot_product).append('\'').append('\n');
      localStringBuffer.append(", shoot_model='").append(this.shoot_model).append('\'').append('\n');
      localStringBuffer.append(", picture_format='").append(this.picture_format).append('\'').append('\n');
      localStringBuffer.append(", country_name='").append(this.country_name).append('\'').append('\n');
      localStringBuffer.append(", prov_name='").append(this.prov_name).append('\'').append('\n');
      localStringBuffer.append(", city_name='").append(this.city_name).append('\'').append('\n');
      localStringBuffer.append(", place_name='").append(this.place_name).append('\'').append('\n');
    }
    localStringBuffer.append(", feed_tag='").append(this.feed_tag).append('\'').append('\n');
    localStringBuffer.append(", author_uin=").append(this.author_uin).append('\n');
    localStringBuffer.append(", shoot_place='").append(this.shoot_place).append('\'').append('\n');
    localStringBuffer.append(", albumId='").append(this.albumId).append('\'').append('\n');
    localStringBuffer.append(", traceId='").append(this.traceId).append('\'').append('\n');
    localStringBuffer.append(", origPicWidth=").append(this.origPicWidth).append('\n');
    localStringBuffer.append(", origPicHeight=").append(this.origPicHeight).append('\n');
    localStringBuffer.append(", origPicSize=").append(this.origPicSize).append('\n');
    localStringBuffer.append(", mediaOriginBitrate=").append(this.mediaOriginBitrate).append('\n');
    localStringBuffer.append(", edited_pic_width=").append(this.edited_pic_width).append('\n');
    localStringBuffer.append(", edited_pic_height=").append(this.edited_pic_height).append('\n');
    localStringBuffer.append(", edited_pic_size=").append(this.edited_pic_size).append('\n');
    localStringBuffer.append(", edited_video_mediaBitrate=").append(this.edited_video_mediaBitrate).append('\n');
    localStringBuffer.append(", client_compress_pic_width=").append(this.client_compress_pic_width).append('\n');
    localStringBuffer.append(", client_compress_pic_height=").append(this.client_compress_pic_height).append('\n');
    localStringBuffer.append(", client_compress_pic_size=").append(this.client_compress_pic_size).append('\n');
    localStringBuffer.append(", client_compress_mediaBitrate=").append(this.client_compress_mediaBitrate).append('\n');
    localStringBuffer.append(", backendPicWidth=").append(this.backendPicWidth).append('\n');
    localStringBuffer.append(", backendPicHeight=").append(this.backendPicHeight).append('\n');
    localStringBuffer.append(", backendPicSize=").append(this.backendPicSize).append('\n');
    localStringBuffer.append(", hasCompress=").append(this.hasCompress).append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleTaskReportInfo
 * JD-Core Version:    0.7.0.1
 */