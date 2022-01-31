import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class swj
  implements axme
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
  
  public swj(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
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
  
  public axmf a(int paramInt1, int paramInt2)
  {
    axmf localaxmf = new axmf();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localaxmf.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localaxmf.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localaxmf.jdField_a_of_type_Float = (960.0F / paramInt2);
      localaxmf.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localaxmf.jdField_b_of_type_Boolean = a();
      localaxmf.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localaxmf.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localaxmf.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localaxmf.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localaxmf.g = this.jdField_d_of_type_Int;
      localaxmf.h = this.e;
      localaxmf.i = this.f;
      localaxmf.j = this.g;
      localaxmf.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localaxmf.jdField_a_of_type_Boolean = true;
        localaxmf.jdField_d_of_type_Int = 8;
        localaxmf.e = 512;
      }
      if (tcv.e())
      {
        veg.d(swf.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (tcv)tdc.a(10);
        paramInt1 = ((Integer)((tcv)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((tcv)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localaxmf.f))).intValue();
        boolean bool = ((Boolean)((tcv)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localaxmf.f = paramInt2;
        localaxmf.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localaxmf.jdField_a_of_type_Boolean = true;
        localaxmf.jdField_d_of_type_Int = 8;
      }
    }
    for (localaxmf.e = 512;; localaxmf.e = 512)
    {
      veg.a(swf.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localaxmf.jdField_b_of_type_Boolean + ", scaleRate=" + localaxmf.jdField_a_of_type_Float + ", videoBitRate=" + localaxmf.jdField_a_of_type_Int + ", videoFrameRate=" + localaxmf.jdField_b_of_type_Int + ", beginTime=" + localaxmf.jdField_a_of_type_Long + ", endTime=" + localaxmf.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localaxmf.f + ",setProfileLevel=" + localaxmf.jdField_a_of_type_Boolean + ",profile=" + localaxmf.jdField_d_of_type_Int + ", level=" + localaxmf.e);
      return localaxmf;
      paramInt2 = paramInt1;
      break;
      label571:
      localaxmf.jdField_a_of_type_Boolean = false;
      localaxmf.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    veg.e(swf.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    veg.b(swf.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    veg.e(swf.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
    veg.c(swf.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swj
 * JD-Core Version:    0.7.0.1
 */