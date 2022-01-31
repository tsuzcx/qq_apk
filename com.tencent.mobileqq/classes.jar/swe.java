import com.tencent.biz.qqstory.database.PublishVideoEntry;

class swe
  extends bjdv
{
  private long jdField_a_of_type_Long;
  
  swe(swc paramswc, PublishVideoEntry paramPublishVideoEntry, swi paramswi, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Swi.a(-3);
    this.jdField_a_of_type_Swi.a("task canceled");
    swc.a(this.jdField_a_of_type_Swc, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    ved.c(swc.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    ved.c(swc.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Swi.a(paramInt);
      this.jdField_a_of_type_Swi.a("unknown error the music download failed");
    }
    for (;;)
    {
      xhb.a("edit_music_download", xhb.a(this.jdField_a_of_type_Swi.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, vyf.a(paramString)));
      swc.a(this.jdField_a_of_type_Swc, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Swi.a(0);
      this.jdField_a_of_type_Swi.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Swi.a(-2);
      this.jdField_a_of_type_Swi.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swe
 * JD-Core Version:    0.7.0.1
 */