import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;

public class qsw
  implements CompoundButton.OnCheckedChangeListener
{
  public qsw(EditVideoFragment paramEditVideoFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isPressed()) {
      return;
    }
    EditVideoFragment.a(this.a).isRemindQQFriend = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsw
 * JD-Core Version:    0.7.0.1
 */