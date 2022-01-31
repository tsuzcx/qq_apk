import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class sjn
  implements awmy
{
  int jdField_a_of_type_Int = 1024000;
  final long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 25;
  final long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  int g;
  
  public sjn(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
  }
  
  public awmz a(int paramInt1, int paramInt2)
  {
    awmz localawmz = new awmz();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localawmz.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localawmz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localawmz.jdField_a_of_type_Float = (960.0F / paramInt2);
      localawmz.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localawmz.jdField_b_of_type_Boolean = a();
      localawmz.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localawmz.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localawmz.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localawmz.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localawmz.g = this.jdField_d_of_type_Int;
      localawmz.h = this.e;
      localawmz.i = this.f;
      localawmz.j = this.g;
      localawmz.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localawmz.jdField_a_of_type_Boolean = true;
        localawmz.jdField_d_of_type_Int = 8;
        localawmz.e = 512;
      }
      if (spz.e())
      {
        urk.d(sjj.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (spz)sqg.a(10);
        paramInt1 = ((Integer)((spz)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((spz)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localawmz.f))).intValue();
        boolean bool = ((Boolean)((spz)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localawmz.f = paramInt2;
        localawmz.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localawmz.jdField_a_of_type_Boolean = true;
        localawmz.jdField_d_of_type_Int = 8;
      }
    }
    for (localawmz.e = 512;; localawmz.e = 512)
    {
      urk.a(sjj.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localawmz.jdField_b_of_type_Boolean + ", scaleRate=" + localawmz.jdField_a_of_type_Float + ", videoBitRate=" + localawmz.jdField_a_of_type_Int + ", videoFrameRate=" + localawmz.jdField_b_of_type_Int + ", beginTime=" + localawmz.jdField_a_of_type_Long + ", endTime=" + localawmz.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localawmz.f + ",setProfileLevel=" + localawmz.jdField_a_of_type_Boolean + ",profile=" + localawmz.jdField_d_of_type_Int + ", level=" + localawmz.e);
      return localawmz;
      paramInt2 = paramInt1;
      break;
      label571:
      localawmz.jdField_a_of_type_Boolean = false;
      localawmz.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    urk.e(sjj.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    urk.b(sjj.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    urk.e(sjj.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public void b()
  {
    urk.c(sjj.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjn
 * JD-Core Version:    0.7.0.1
 */