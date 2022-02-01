import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class odw
{
  private ViewGroup a;
  
  public odw(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, String paramString1, String paramString2)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2131558434, paramViewGroup));
    paramLayoutInflater = (TextView)this.a.findViewById(2131361921);
    paramViewGroup = (TextView)this.a.findViewById(2131361920);
    paramLayoutInflater.setText(paramString1);
    paramViewGroup.setText(paramString2);
  }
  
  public View a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odw
 * JD-Core Version:    0.7.0.1
 */