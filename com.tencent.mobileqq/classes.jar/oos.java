import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class oos
  implements View.OnClickListener
{
  public oos(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
    Object localObject1 = paramView.getTag();
    try
    {
      i = Integer.valueOf(localObject1.toString()).intValue();
      if ((i >= 0) && (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject1 = (MultiBiuSameContent)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
        switch (paramView.getId())
        {
        default: 
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
        continue;
        if (localException != null)
        {
          String str = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, str);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.b, "0X800953D", localException.c);
          continue;
          if (localException != null)
          {
            str = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.c, localException.b);
            ReadInjoyFriendsBiuComponentFragment.a(this.a, str);
            ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.a, localException.b, "0X800953C", localException.c);
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oos
 * JD-Core Version:    0.7.0.1
 */