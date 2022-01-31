import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class ted
  extends tcq
{
  ted(tdo paramtdo, StoryVideoItem paramStoryVideoItem, tew paramtew)
  {
    super(paramStoryVideoItem);
  }
  
  public boolean b()
  {
    String str = (String)a("result");
    vkw.a(str);
    vkw.a(this.jdField_a_of_type_Tew.d);
    if (this.jdField_a_of_type_Tew.d == null)
    {
      this.jdField_a_of_type_Tew.d = "";
      urk.c(this.b, "imageLocalPath is null", new Throwable());
    }
    a("DownloadPic2FileJob_iiu", str);
    a("DownloadPic2FileJob_isfp", this.jdField_a_of_type_Tew.d);
    a("DownloadPic2FileJob_IN_ROUND", Boolean.valueOf(this.jdField_a_of_type_Tew.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ted
 * JD-Core Version:    0.7.0.1
 */