import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class swg
  implements axmg
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
  
  public swg(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
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
  
  public axmh a(int paramInt1, int paramInt2)
  {
    axmh localaxmh = new axmh();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localaxmh.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localaxmh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localaxmh.jdField_a_of_type_Float = (960.0F / paramInt2);
      localaxmh.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localaxmh.jdField_b_of_type_Boolean = a();
      localaxmh.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localaxmh.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localaxmh.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localaxmh.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localaxmh.g = this.jdField_d_of_type_Int;
      localaxmh.h = this.e;
      localaxmh.i = this.f;
      localaxmh.j = this.g;
      localaxmh.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localaxmh.jdField_a_of_type_Boolean = true;
        localaxmh.jdField_d_of_type_Int = 8;
        localaxmh.e = 512;
      }
      if (tcs.e())
      {
        ved.d(swc.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (tcs)tcz.a(10);
        paramInt1 = ((Integer)((tcs)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((tcs)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localaxmh.f))).intValue();
        boolean bool = ((Boolean)((tcs)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localaxmh.f = paramInt2;
        localaxmh.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localaxmh.jdField_a_of_type_Boolean = true;
        localaxmh.jdField_d_of_type_Int = 8;
      }
    }
    for (localaxmh.e = 512;; localaxmh.e = 512)
    {
      ved.a(swc.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localaxmh.jdField_b_of_type_Boolean + ", scaleRate=" + localaxmh.jdField_a_of_type_Float + ", videoBitRate=" + localaxmh.jdField_a_of_type_Int + ", videoFrameRate=" + localaxmh.jdField_b_of_type_Int + ", beginTime=" + localaxmh.jdField_a_of_type_Long + ", endTime=" + localaxmh.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localaxmh.f + ",setProfileLevel=" + localaxmh.jdField_a_of_type_Boolean + ",profile=" + localaxmh.jdField_d_of_type_Int + ", level=" + localaxmh.e);
      return localaxmh;
      paramInt2 = paramInt1;
      break;
      label571:
      localaxmh.jdField_a_of_type_Boolean = false;
      localaxmh.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    ved.e(swc.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    ved.b(swc.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    ved.e(swc.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
    ved.c(swc.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swg
 * JD-Core Version:    0.7.0.1
 */