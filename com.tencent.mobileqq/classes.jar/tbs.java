import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MakeVideoActivity;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class tbs
  extends Handler
{
  public tbs(MakeVideoActivity paramMakeVideoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      MakeVideoActivity.a(this.a).setVisibility(4);
      MakeVideoActivity.b(this.a).setVisibility(0);
      MakeVideoActivity.c(this.a).setVisibility(0);
      MakeVideoActivity.a(this.a).setVisibility(0);
      return;
    case 2: 
      if (this.a.e < 4)
      {
        ((ImageView)this.a.b.get(this.a.e)).setVisibility(4);
        paramMessage = (TextView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.e);
        paramMessage.setTextColor(Color.parseColor("#ffffff"));
        paramMessage.setText(this.a.jdField_a_of_type_ArrayOfJavaLangString[this.a.e]);
        paramMessage.setVisibility(0);
        if (this.a.e > 0) {
          ((TextView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.e - 1)).setTextColor(Color.parseColor("#00a5e0"));
        }
      }
      for (;;)
      {
        paramMessage = this.a;
        paramMessage.e += 1;
        if (this.a.e >= 6) {
          break;
        }
        MakeVideoActivity.a(this.a).sendEmptyMessageDelayed(2, this.a.d);
        return;
        if (this.a.e == 4)
        {
          ((TextView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.e - 1)).setTextColor(Color.parseColor("#00a5e0"));
        }
        else if (this.a.e == 5)
        {
          MakeVideoActivity.a(this.a).setVisibility(8);
          MakeVideoActivity.b(this.a).setBackgroundColor(Color.parseColor("#ee000000"));
          MakeVideoActivity.a(this.a).setVisibility(0);
          MakeVideoActivity.d(this.a).setVisibility(0);
          MakeVideoActivity.a(this.a).setVisibility(8);
          this.a.b();
          MakeVideoActivity.a(this.a).sendEmptyMessageDelayed(3, 500L);
        }
      }
    }
    paramMessage = new File(this.a.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    if ((paramMessage.exists()) && (paramMessage.length() > 0L))
    {
      paramMessage = new Intent();
      paramMessage.putExtra("path", this.a.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      this.a.setResult(-1, paramMessage);
      this.a.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.a.finish();
      return;
      paramMessage = new JSONObject();
      try
      {
        paramMessage.put("errCode", 0);
        paramMessage.put("msg", "视频录制失败");
        paramMessage.put("content", "");
        Intent localIntent = new Intent();
        localIntent.putExtra("result", paramMessage.toString());
        this.a.setResult(-3, localIntent);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbs
 * JD-Core Version:    0.7.0.1
 */