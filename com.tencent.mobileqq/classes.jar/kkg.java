import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.widget.ShareActionSheetBuilder;
import com.tencent.common.config.AppSetting;
import mqq.app.BaseActivity;

public class kkg
  extends BaseAdapter
{
  private kkg(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
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
      paramViewGroup = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2130971697, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131435325;
      j = 2130838337;
      paramInt = 2131435349;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131366749);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131364341);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131435317;
      j = 2130838341;
      paramInt = 2131435347;
      continue;
      i = 2131435324;
      j = 2130838342;
      paramInt = 2131435348;
      continue;
      i = 2131435315;
      j = 2130838345;
      paramInt = 2131435346;
      continue;
      i = 2131435314;
      j = 2130838339;
      paramInt = 2131435345;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kkg
 * JD-Core Version:    0.7.0.1
 */