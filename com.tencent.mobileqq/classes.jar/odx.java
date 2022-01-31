import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import java.util.ArrayList;

public class odx
  implements View.OnClickListener
{
  public odx(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
    Object localObject2;
    for (Object localObject1 = paramView.getTag();; localObject2 = null) {
      for (;;)
      {
        try
        {
          i = Integer.valueOf(localObject1.toString()).intValue();
          if ((i < 0) || (i >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
            break;
          }
          localObject1 = (MultiBiuSameContent)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        }
        catch (Exception localException)
        {
          int i = -1;
          continue;
          if (localException == null) {
            continue;
          }
          paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.b, "0X800953D", localException.c);
          return;
        }
        if (localException != null)
        {
          paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.c, localException.b);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.b, "0X800953C", localException.c);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odx
 * JD-Core Version:    0.7.0.1
 */