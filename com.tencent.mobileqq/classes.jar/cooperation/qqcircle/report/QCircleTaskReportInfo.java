package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
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
  public boolean hasCompress = false;
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
  public long retCode;
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
    localStringBuffer.append("retCode=");
    localStringBuffer.append(this.retCode);
    localStringBuffer.append('\n');
    localStringBuffer.append(", up_source=");
    localStringBuffer.append(this.up_source);
    localStringBuffer.append('\n');
    localStringBuffer.append(", up_type=");
    localStringBuffer.append(this.up_type);
    localStringBuffer.append('\n');
    localStringBuffer.append(", is_video=");
    localStringBuffer.append(this.is_video);
    localStringBuffer.append('\n');
    localStringBuffer.append(", txtinfo='");
    localStringBuffer.append(this.txtinfo);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", lloc='");
    localStringBuffer.append(this.lloc);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", vid='");
    localStringBuffer.append(this.vid);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", feedid='");
    localStringBuffer.append(this.feedid);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", total_upload_num=");
    localStringBuffer.append(this.total_upload_num);
    localStringBuffer.append('\n');
    localStringBuffer.append(", shooting_time='");
    localStringBuffer.append(this.shooting_time);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    if (RFLog.isColorLevel())
    {
      localStringBuffer.append(", place='");
      localStringBuffer.append(this.place);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", up_place='");
      localStringBuffer.append(this.up_place);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", shoot_product='");
      localStringBuffer.append(this.shoot_product);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", shoot_model='");
      localStringBuffer.append(this.shoot_model);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", picture_format='");
      localStringBuffer.append(this.picture_format);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", country_name='");
      localStringBuffer.append(this.country_name);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", prov_name='");
      localStringBuffer.append(this.prov_name);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", city_name='");
      localStringBuffer.append(this.city_name);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
      localStringBuffer.append(", place_name='");
      localStringBuffer.append(this.place_name);
      localStringBuffer.append('\'');
      localStringBuffer.append('\n');
    }
    localStringBuffer.append(", feed_tag='");
    localStringBuffer.append(this.feed_tag);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", author_uin=");
    localStringBuffer.append(this.author_uin);
    localStringBuffer.append('\n');
    localStringBuffer.append(", shoot_place='");
    localStringBuffer.append(this.shoot_place);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", albumId='");
    localStringBuffer.append(this.albumId);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", traceId='");
    localStringBuffer.append(this.traceId);
    localStringBuffer.append('\'');
    localStringBuffer.append('\n');
    localStringBuffer.append(", origPicWidth=");
    localStringBuffer.append(this.origPicWidth);
    localStringBuffer.append('\n');
    localStringBuffer.append(", origPicHeight=");
    localStringBuffer.append(this.origPicHeight);
    localStringBuffer.append('\n');
    localStringBuffer.append(", origPicSize=");
    localStringBuffer.append(this.origPicSize);
    localStringBuffer.append('\n');
    localStringBuffer.append(", mediaOriginBitrate=");
    localStringBuffer.append(this.mediaOriginBitrate);
    localStringBuffer.append('\n');
    localStringBuffer.append(", edited_pic_width=");
    localStringBuffer.append(this.edited_pic_width);
    localStringBuffer.append('\n');
    localStringBuffer.append(", edited_pic_height=");
    localStringBuffer.append(this.edited_pic_height);
    localStringBuffer.append('\n');
    localStringBuffer.append(", edited_pic_size=");
    localStringBuffer.append(this.edited_pic_size);
    localStringBuffer.append('\n');
    localStringBuffer.append(", edited_video_mediaBitrate=");
    localStringBuffer.append(this.edited_video_mediaBitrate);
    localStringBuffer.append('\n');
    localStringBuffer.append(", client_compress_pic_width=");
    localStringBuffer.append(this.client_compress_pic_width);
    localStringBuffer.append('\n');
    localStringBuffer.append(", client_compress_pic_height=");
    localStringBuffer.append(this.client_compress_pic_height);
    localStringBuffer.append('\n');
    localStringBuffer.append(", client_compress_pic_size=");
    localStringBuffer.append(this.client_compress_pic_size);
    localStringBuffer.append('\n');
    localStringBuffer.append(", client_compress_mediaBitrate=");
    localStringBuffer.append(this.client_compress_mediaBitrate);
    localStringBuffer.append('\n');
    localStringBuffer.append(", backendPicWidth=");
    localStringBuffer.append(this.backendPicWidth);
    localStringBuffer.append('\n');
    localStringBuffer.append(", backendPicHeight=");
    localStringBuffer.append(this.backendPicHeight);
    localStringBuffer.append('\n');
    localStringBuffer.append(", backendPicSize=");
    localStringBuffer.append(this.backendPicSize);
    localStringBuffer.append('\n');
    localStringBuffer.append(", hasCompress=");
    localStringBuffer.append(this.hasCompress);
    localStringBuffer.append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleTaskReportInfo
 * JD-Core Version:    0.7.0.1
 */