import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.widget.ShareActionSheetBuilder;
import com.tencent.common.config.AppSetting;
import mqq.app.BaseActivity;

public class kio
  extends BaseAdapter
{
  private kio(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
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
      paramViewGroup = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2130971620, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131435292;
      j = 2130838328;
      paramInt = 2131435316;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131366708);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131364292);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131435284;
      j = 2130838332;
      paramInt = 2131435314;
      continue;
      i = 2131435291;
      j = 2130838333;
      paramInt = 2131435315;
      continue;
      i = 2131435282;
      j = 2130838336;
      paramInt = 2131435313;
      continue;
      i = 2131435281;
      j = 2130838330;
      paramInt = 2131435312;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kio
 * JD-Core Version:    0.7.0.1
 */