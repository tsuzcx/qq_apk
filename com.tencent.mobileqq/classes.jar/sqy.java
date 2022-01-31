import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class sqy
  extends sfo
{
  public long a;
  public String a;
  public String b;
  
  public sqy(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramStoryVideoItem.mVideoIndex;
    this.b = paramStoryVideoItem.mVid;
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramStoryVideoItem.mCreateTime;
    }
  }
  
  public String toString()
  {
    return "ReadStoryVideoEvent{unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", videoIndex=" + this.jdField_a_of_type_Long + ", vid='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqy
 * JD-Core Version:    0.7.0.1
 */