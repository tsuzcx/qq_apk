import com.tencent.biz.qqstory.database.PublishVideoEntry;

class swh
  extends bjde
{
  private long jdField_a_of_type_Long;
  
  swh(swf paramswf, PublishVideoEntry paramPublishVideoEntry, swl paramswl, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Swl.a(-3);
    this.jdField_a_of_type_Swl.a("task canceled");
    swf.a(this.jdField_a_of_type_Swf, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    veg.c(swf.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    veg.c(swf.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Swl.a(paramInt);
      this.jdField_a_of_type_Swl.a("unknown error the music download failed");
    }
    for (;;)
    {
      xhe.a("edit_music_download", xhe.a(this.jdField_a_of_type_Swl.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, vyi.a(paramString)));
      swf.a(this.jdField_a_of_type_Swf, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Swl.a(0);
      this.jdField_a_of_type_Swl.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Swl.a(-2);
      this.jdField_a_of_type_Swl.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swh
 * JD-Core Version:    0.7.0.1
 */