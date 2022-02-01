package dov.com.tencent.biz.qqstory.takevideo.music;

import com.tencent.mobileqq.app.HardCodeUtil;

public class QQStoryMusicInfo
{
  public static final QQStoryMusicInfo a;
  public static final QQStoryMusicInfo b;
  public static final QQStoryMusicInfo c;
  int a;
  public String a;
  public int b;
  public String b;
  public int c;
  String c;
  public int d;
  String d;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = null;
  public int f;
  String f;
  String g = null;
  public String h = null;
  
  static
  {
    jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(0, HardCodeUtil.a(2131710915));
    jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(1, HardCodeUtil.a(2131710906));
    jdField_c_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(2, "QQ音乐曲库");
  }
  
  public QQStoryMusicInfo()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
  }
  
  public QQStoryMusicInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)paramObject;
    if ((localQQStoryMusicInfo.jdField_b_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0)) {
      return true;
    }
    if ((localQQStoryMusicInfo.jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1)) {
      return true;
    }
    if ((localQQStoryMusicInfo.jdField_b_of_type_Int == this.jdField_b_of_type_Int) && (localQQStoryMusicInfo.jdField_b_of_type_JavaLangString != null) && (localQQStoryMusicInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (localQQStoryMusicInfo.jdField_d_of_type_JavaLangString != null) && (localQQStoryMusicInfo.jdField_d_of_type_JavaLangString.equals(this.jdField_d_of_type_JavaLangString))) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo
 * JD-Core Version:    0.7.0.1
 */