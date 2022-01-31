import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class qda
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public qda() {}
  
  public qda(articlesummary.PGCVideoInfo paramPGCVideoInfo)
  {
    if (paramPGCVideoInfo.bytes_pic_md5.has()) {
      this.c = paramPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_pic_url.has()) {
      this.d = paramPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_vid.has()) {
      this.e = paramPGCVideoInfo.bytes_vid.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_video_url.has()) {
      this.jdField_b_of_type_JavaLangString = paramPGCVideoInfo.bytes_video_url.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.bytes_video_md5.has()) {
      this.jdField_a_of_type_JavaLangString = paramPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
    }
    if (paramPGCVideoInfo.uint32_duration.has()) {
      this.jdField_a_of_type_Int = paramPGCVideoInfo.uint32_duration.get();
    }
    if (paramPGCVideoInfo.uint32_busi_type.has()) {
      this.jdField_b_of_type_Int = paramPGCVideoInfo.uint32_busi_type.get();
    }
    if (paramPGCVideoInfo.uint64_play_num.has()) {
      this.jdField_a_of_type_Long = paramPGCVideoInfo.uint64_play_num.get();
    }
    if (paramPGCVideoInfo.video_auto_play.has()) {
      this.jdField_a_of_type_Boolean = paramPGCVideoInfo.video_auto_play.get();
    }
    if (paramPGCVideoInfo.title.has()) {
      this.g = paramPGCVideoInfo.title.get();
    }
    if (paramPGCVideoInfo.rowkey.has()) {
      this.f = paramPGCVideoInfo.rowkey.get();
    }
    if (paramPGCVideoInfo.jump_url.has()) {
      this.h = paramPGCVideoInfo.jump_url.get();
    }
  }
  
  public articlesummary.PGCVideoInfo a()
  {
    articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
    if (this.h != null) {
      localPGCVideoInfo.jump_url.set(this.h);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localPGCVideoInfo.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localPGCVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localPGCVideoInfo.rowkey.set(this.f);
    }
    if (!TextUtils.isEmpty(this.g)) {
      localPGCVideoInfo.title.set(this.g);
    }
    localPGCVideoInfo.video_auto_play.set(this.jdField_a_of_type_Boolean);
    localPGCVideoInfo.uint64_play_num.set(this.jdField_a_of_type_Long);
    localPGCVideoInfo.uint32_busi_type.set(this.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.c)) {
      localPGCVideoInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localPGCVideoInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localPGCVideoInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    localPGCVideoInfo.uint32_duration.set(this.jdField_a_of_type_Int);
    return localPGCVideoInfo;
  }
  
  public String toString()
  {
    return "PGCVideoInfo{video_md5='" + this.jdField_a_of_type_JavaLangString + '\'' + ", video_url='" + this.jdField_b_of_type_JavaLangString + '\'' + ", pic_md5='" + this.c + '\'' + ", pic_url='" + this.d + '\'' + ", vid='" + this.e + '\'' + ", duration='" + this.jdField_a_of_type_Int + '\'' + ", busi_type='" + this.jdField_b_of_type_Int + '\'' + ", playCount='" + this.jdField_a_of_type_Long + '\'' + ", isVideoAutoPlay='" + this.jdField_a_of_type_Boolean + '\'' + ", rowkey='" + this.f + '\'' + ", title='" + this.g + '\'' + ", jumpUrl='" + this.h + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qda
 * JD-Core Version:    0.7.0.1
 */