import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

public class ngg
  implements EmoticonCallback
{
  public ngg(StoryInputBarView paramStoryInputBarView) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(QQStoryContext.a(), this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      TextUtils.a(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngg
 * JD-Core Version:    0.7.0.1
 */