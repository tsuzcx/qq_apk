import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class nlu
  implements nkv
{
  private ArrayList<Pair<String, Boolean>> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  nkw jdField_a_of_type_Nkw;
  nky jdField_a_of_type_Nky;
  
  public nlu(nkw paramnkw)
  {
    this.jdField_a_of_type_Nkw = paramnkw;
  }
  
  public String a(Context paramContext, nfv paramnfv)
  {
    paramContext = "";
    Object localObject = paramnfv.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690343);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramnfv.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label98;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        break label109;
      }
      return localObject;
      paramContext = ((nga)localObject).m;
      break;
      label98:
      QLog.e("GuessPictureStagePresenter", 1, "textTypeString tips isEmpty");
    }
    label109:
    return paramContext + (String)localObject;
  }
  
  public String a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    return paramContext.getResources().getString(2131690342);
  }
  
  public nky a()
  {
    return this.jdField_a_of_type_Nky;
  }
  
  public void a(nfh paramnfh)
  {
    this.jdField_a_of_type_Nkw.a(paramnfh);
  }
  
  public void a(nfv paramnfv)
  {
    a(nfc.a(paramnfv), false);
    this.jdField_a_of_type_Nky.a().e(false);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nky = paramnky;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nkw.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nkw.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(nfv paramnfv)
  {
    nfh localnfh = paramnfv.a();
    a(nfc.a(paramnfv), true);
    a(localnfh);
    this.jdField_a_of_type_Nky.a().e(true);
    if (paramnfv.a().a.a()) {
      this.jdField_a_of_type_Nky.a().a(paramnfv.a().a.c * 1000, paramnfv.a().e());
    }
    for (;;)
    {
      this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().f(), paramnfv.a().d());
      if (localnfh != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localnfh.b(), Boolean.valueOf(false)));
      }
      return;
      String str = paramnfv.e() + 1 + "/" + paramnfv.f();
      this.jdField_a_of_type_Nky.a().b(str);
    }
  }
  
  public void c(nfv paramnfv)
  {
    nfh localnfh = paramnfv.a();
    a(nfc.a(paramnfv), true);
    a(localnfh);
    if (paramnfv.a().a.a()) {
      this.jdField_a_of_type_Nky.a().a(paramnfv.a().a.c * 1000, paramnfv.a().e());
    }
    for (;;)
    {
      this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().f(), paramnfv.a().d());
      if (localnfh != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localnfh.b(), Boolean.valueOf(false)));
      }
      return;
      String str = paramnfv.e() + 1 + "/" + paramnfv.f();
      this.jdField_a_of_type_Nky.a().b(str);
    }
  }
  
  public void d(nfv paramnfv)
  {
    paramnfv = paramnfv.a();
    if ((paramnfv != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramnfv = paramnfv.b();
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramnfv, Boolean.valueOf(true)));
      QLog.d("GuessPictureStagePresenter", 2, "onAnswerRight " + paramnfv);
    }
  }
  
  public void e(nfv paramnfv) {}
  
  public void f(nfv paramnfv)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      paramnfv = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (!((Boolean)((Pair)localObject2).second).booleanValue()) {
          paramnfv.add(((Pair)localObject2).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver all:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " notAnswer:" + paramnfv.size());
      }
      localObject1 = new Random();
      if (paramnfv.isEmpty())
      {
        i = ((Random)localObject1).nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label362;
        }
        paramnfv = (String)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i)).first;
      }
    }
    for (;;)
    {
      localObject2 = a().a().b();
      localObject1 = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(paramnfv)) {
          ((JSONObject)localObject1).putOpt("textContent", paramnfv);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).putOpt("bgUrl", localObject2);
        }
      }
      catch (JSONException paramnfv)
      {
        for (;;)
        {
          QLog.d("GuessPictureStagePresenter", 2, paramnfv, new Object[0]);
        }
      }
      paramnfv = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver str:" + paramnfv);
      }
      nfc.a().a().a(paramnfv);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      if (paramnfv.size() == 1)
      {
        paramnfv = (String)paramnfv.get(0);
      }
      else
      {
        i = ((Random)localObject1).nextInt(paramnfv.size());
        if (i < paramnfv.size()) {
          paramnfv = (String)paramnfv.get(i);
        } else {
          label362:
          paramnfv = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlu
 * JD-Core Version:    0.7.0.1
 */