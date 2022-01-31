import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;

public class nxl
  implements DialogInterface.OnClickListener
{
  public nxl(StoryPickerFragment paramStoryPickerFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("extra_checked_vidset", this.a.a);
    this.a.getActivity().setResult(-1, paramDialogInterface);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxl
 * JD-Core Version:    0.7.0.1
 */