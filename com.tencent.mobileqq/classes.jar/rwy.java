import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.utils.FileUtils;

public class rwy
  implements QueryCallback
{
  public rwy(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    Object localObject;
    int i;
    if (paramPicEmoticonInfo != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramPicEmoticonInfo);
      String str2 = EmoticonUtils.z.replace("[epId]", paramPicEmoticonInfo.a.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = PngFrameUtil.a((String)localObject);
      if ((!FileUtils.a(str2)) || (i != 1)) {
        break label190;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramPicEmoticonInfo.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130843854);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.b, i, paramPicEmoticonInfo);
        return;
        label190:
        if (paramPicEmoticonInfo.b())
        {
          i = 2;
          break;
        }
        if (!paramPicEmoticonInfo.c()) {
          break label254;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130837573);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label254:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwy
 * JD-Core Version:    0.7.0.1
 */