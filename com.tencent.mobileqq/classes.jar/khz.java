import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.widget.ShareActionSheetBuilder;
import com.tencent.common.config.AppSetting;
import mqq.app.BaseActivity;

public class khz
  extends BaseAdapter
{
  private khz(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
  public int getCount()
  {
    return 5;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2130971668, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131435309;
      j = 2130838332;
      paramInt = 2131435333;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131366751);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131364316);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131435301;
      j = 2130838336;
      paramInt = 2131435331;
      continue;
      i = 2131435308;
      j = 2130838337;
      paramInt = 2131435332;
      continue;
      i = 2131435299;
      j = 2130838340;
      paramInt = 2131435330;
      continue;
      i = 2131435298;
      j = 2130838334;
      paramInt = 2131435329;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khz
 * JD-Core Version:    0.7.0.1
 */