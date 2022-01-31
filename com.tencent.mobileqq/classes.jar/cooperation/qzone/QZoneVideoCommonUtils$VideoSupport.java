package cooperation.qzone;

public class QZoneVideoCommonUtils$VideoSupport
{
  public static final VideoSupport a;
  public static final VideoSupport b;
  public static final VideoSupport c;
  public static final VideoSupport d = new VideoSupport(false, "硬件配置过低", false, true);
  public static final VideoSupport e = new VideoSupport(false, "系统版本太低", false, true);
  public static final VideoSupport f = new VideoSupport(false, "sd卡不可用，无法使用视频录制功能，请检查sd卡", true, true);
  public static final VideoSupport g = new VideoSupport(false, "sd卡存储空间不足，无法使用视频录制功能，请清理sd卡", true, true);
  public static final VideoSupport h = new VideoSupport(false, "硬件编解码特性不支持", false, true);
  public static final VideoSupport i = new VideoSupport(false, "加载库失败，请卸载重装或重启手机", true, true);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_CooperationQzoneQZoneVideoCommonUtils$VideoSupport = new VideoSupport(true, "可用", false, false);
    jdField_b_of_type_CooperationQzoneQZoneVideoCommonUtils$VideoSupport = new VideoSupport(false, "CPU指令集不支持", false, true);
    jdField_c_of_type_CooperationQzoneQZoneVideoCommonUtils$VideoSupport = new VideoSupport(false, "机型黑名单", false, true);
  }
  
  QZoneVideoCommonUtils$VideoSupport(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoCommonUtils.VideoSupport
 * JD-Core Version:    0.7.0.1
 */