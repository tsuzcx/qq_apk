import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.config.ConfigInfo;

public class mes
  implements View.OnClickListener
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new met(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private long[] jdField_a_of_type_ArrayOfLong;
  private boolean b;
  
  public mes(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfLong = new long[6];
  }
  
  private void a(View paramView)
  {
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    ((Activity)localObject).findViewById(2131372589).setVisibility(0);
    paramView = (TextView)((Activity)localObject).findViewById(2131372591);
    localObject = (TextView)((Activity)localObject).findViewById(2131372590);
    int i = ConfigInfo.getSharpConfigVersionFromFile(this.jdField_a_of_type_AndroidContentContext);
    String str2 = a(ConfigInfo.getSharpConfigPayloadFromFile(this.jdField_a_of_type_AndroidContentContext));
    String str1 = lno.a(this.jdField_a_of_type_AndroidContentContext);
    str2 = str2 + "\n----------\n";
    str1 = str2 + a(str1);
    paramView.setText(i + "|" + lyf.a().a("load"));
    ((TextView)localObject).setText(str1);
  }
  
  private void c() {}
  
  String a(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    paramString = new String();
    int n = arrayOfString.length;
    int k = 0;
    int i = 0;
    String str;
    int j;
    if (k < n)
    {
      str = arrayOfString[k];
      j = str.length();
      if (j < 2) {
        break label172;
      }
    }
    label172:
    for (int m = str.charAt(j - 2);; m = 0)
    {
      j = i;
      if (m == 125) {
        j = i - 1;
      }
      i = 0;
      while (i < j)
      {
        paramString = paramString + "\t";
        i += 1;
      }
      paramString = paramString + str;
      paramString = paramString + "\n";
      i = j;
      if (m == 123) {
        i = j + 1;
      }
      k += 1;
      break;
      return paramString;
    }
  }
  
  public void a()
  {
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    View localView = ((Activity)localObject).findViewById(2131372588);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      localView.setVisibility(0);
    }
    localView = ((Activity)localObject).findViewById(2131372590);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localObject = ((Activity)localObject).findViewById(2131372589);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131372588: 
      do
      {
        return;
        System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
        this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      } while (this.jdField_a_of_type_ArrayOfLong[0] < SystemClock.uptimeMillis() - 2000L);
      a(paramView);
      return;
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131372589).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mes
 * JD-Core Version:    0.7.0.1
 */