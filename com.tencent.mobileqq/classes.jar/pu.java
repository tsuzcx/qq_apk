import android.view.View;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

public class pu
  implements Runnable
{
  public pu(ETTextView paramETTextView) {}
  
  public void run()
  {
    if (this.a.getTag(2131362292) != null) {}
    for (boolean bool = ((Boolean)this.a.getTag(2131362292)).booleanValue();; bool = false)
    {
      if ((this.a.i) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick != null) && (!bool))
      {
        if (this.a.c())
        {
          Object localObject = this.a.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.a.d, this.a.e);
          if ((localObject instanceof QQText.SmallEmojiSpan))
          {
            localObject = (QQText.SmallEmojiSpan)localObject;
            this.a.b = ((QQText.SmallEmojiSpan)localObject).e;
            this.a.c = ((QQText.SmallEmojiSpan)localObject).f;
            if (QLog.isColorLevel()) {
              QLog.d("ETTextView", 2, "click span: " + this.a.b);
            }
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick.a(this.a);
      }
      this.a.setTag(2131362292, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pu
 * JD-Core Version:    0.7.0.1
 */