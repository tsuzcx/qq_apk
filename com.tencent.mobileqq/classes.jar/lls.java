import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class lls
  extends EffectConfigBase<ZimuItem>
  implements ljr
{
  protected boolean a;
  boolean b = false;
  boolean c = false;
  
  public lls(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_zimu", 4);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = a(paramContext).edit();
    paramContext.putInt("qav_zimu_is_show", paramInt);
    paramContext.commit();
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    ((lls)paramVideoAppInterface.a(0)).b();
    return a(paramVideoAppInterface.getApp()).getInt("qav_zimu_is_show", 0) == 1;
  }
  
  private boolean b(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("switch")) {
          return bool;
        }
        paramString = paramString.getString("switch");
        lek.c("EffectZimuManager", "parse ZIMU:" + paramString);
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase("off")))
        {
          a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 0);
          return true;
        }
        a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), 1);
        return true;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int a()
  {
    return 216;
  }
  
  public Class<?> a()
  {
    return ZimuItem.class;
  }
  
  public List<ZimuItem> a(int paramInt, String paramString)
  {
    List localList = super.a(paramInt, paramString);
    b(paramString);
    return localList;
  }
  
  public List<ZimuItem> a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    ljq localljq = (ljq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (localljq != null) {
      localljq.a(3001, this);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 3002) || (paramInt == 3003)) {
      a(AudioHelper.b(), "");
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QLog.w("EffectZimuManager", 1, "onSessionStatusChanged, event[" + paramInt + "], seq[" + paramLong + "]");
    ((liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();
    new mfa(paramLong, "onSessionStatusChanged", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.b)
    {
      liy localliy = (liy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
      localliy.a(paramString, paramLong, "TransInfo.ExitSession", null);
      localliy.onDestroy();
      ((liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();
    }
    this.b = false;
    lvt.a().b(4);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, String paramString2)
  {
    lvt.a().a(4);
    if (!this.b)
    {
      liv localliv = (liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1);
      localliv.a(paramString1, "TransInfoCreate.CreateSession", paramLong, paramString2);
      localliv.onDestroy();
      this.c = paramBoolean;
    }
    this.b = true;
  }
  
  public void a(boolean paramBoolean)
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label77;
      }
      ZimuItem localZimuItem = (ZimuItem)localIterator.next();
      if ((!llr.a(localZimuItem.getId())) || (localZimuItem.isUsable() == paramBoolean)) {
        break label82;
      }
      localZimuItem.setUsable(paramBoolean);
      i = 1;
    }
    label77:
    label82:
    for (;;)
    {
      break;
      j = 0;
      if (j != 0) {}
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong, ZimuItem paramZimuItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectZimuManager", 1, "setCurrentItem, seq[" + paramLong + "], item[" + paramZimuItem + "]", new Throwable("打印调用栈"));
    }
    boolean bool = super.a(paramLong, paramZimuItem);
    Object localObject;
    if (bool)
    {
      if (paramZimuItem == null)
      {
        localObject = null;
        llt.a((String)localObject);
        b("setCurrentItem_" + (String)localObject + "_" + paramLong, false);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (this.jdField_a_of_type_Ljo != null) {
        break label208;
      }
    }
    label208:
    for (int i = 4;; i = 5)
    {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(165), Integer.valueOf(i) });
      if (paramZimuItem != null)
      {
        localObject = (ljq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
        if (localObject != null) {
          ((ljq)localObject).a(3001, paramZimuItem.getId());
        }
      }
      return bool;
      localObject = paramZimuItem.getId();
      break;
    }
  }
  
  protected boolean a(String paramString)
  {
    return b(a());
  }
  
  public int b()
  {
    if ((ZimuItem)a() == null) {}
    return 4;
  }
  
  public void b(String paramString, long paramLong)
  {
    lvt.a().a(4);
    if (this.b)
    {
      liy localliy = (liy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
      localliy.a(paramString, paramLong, "TransInfo.ChangeSession", null);
      localliy.onDestroy();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      QLog.w("EffectZimuManager", 1, "setRecievedSentence, from[" + paramString + "], mIsRecieveSentence[" + this.jdField_a_of_type_Boolean + "->" + paramBoolean + "]");
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lls
 * JD-Core Version:    0.7.0.1
 */