import com.tencent.biz.qqstory.database.PublishVideoEntry;

class sjl
  extends bhim
{
  private long jdField_a_of_type_Long;
  
  sjl(sjj paramsjj, PublishVideoEntry paramPublishVideoEntry, sjp paramsjp, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Sjp.a(-3);
    this.jdField_a_of_type_Sjp.a("task canceled");
    sjj.a(this.jdField_a_of_type_Sjj, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    urk.c(sjj.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    urk.c(sjj.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Sjp.a(paramInt);
      this.jdField_a_of_type_Sjp.a("unknown error the music download failed");
    }
    for (;;)
    {
      wye.a("edit_music_download", wye.a(this.jdField_a_of_type_Sjp.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, vlm.a(paramString)));
      sjj.a(this.jdField_a_of_type_Sjj, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Sjp.a(0);
      this.jdField_a_of_type_Sjp.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Sjp.a(-2);
      this.jdField_a_of_type_Sjp.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjl
 * JD-Core Version:    0.7.0.1
 */