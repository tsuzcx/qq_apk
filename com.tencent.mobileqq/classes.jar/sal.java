import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;

public class sal
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramContext == null) {
      return;
    }
    paramString2 = (Activity)paramContext;
    paramContext = paramString2;
    if ((paramString2 instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramString2).getOutActivity();
    }
    paramString2 = new Intent(paramContext, ForwardRecentActivity.class);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.putExtra("forward_type", 2);
      paramString2.putExtra("req_type", 1);
      paramString2.putExtra("req_share_id", Long.parseLong("1101083114"));
      paramString2.putExtra("title", paramString1);
      paramString2.putExtra("app_name", ajjy.a(2131651126));
      paramString2.putExtra("image_url_remote", paramString3);
      paramString2.putExtra("desc", ajjy.a(2131651125));
      paramString2.putExtra("detail_url", paramString4);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((QZoneShareData)localObject).c = paramString2;
    ((QZoneShareData)localObject).a = new ArrayList();
    ((QZoneShareData)localObject).a.add(paramString3);
    ((QZoneShareData)localObject).jdField_b_of_type_Int = 0;
    ((QZoneShareData)localObject).d = paramString4;
    ((QZoneShareData)localObject).f = paramString5;
    bfqn.a(paramContext, paramString5, (QZoneShareData)localObject, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sal
 * JD-Core Version:    0.7.0.1
 */