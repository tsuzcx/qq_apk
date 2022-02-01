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

public class ndv
  implements ncy
{
  private ArrayList<Pair<String, Boolean>> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  ncz jdField_a_of_type_Ncz;
  nda jdField_a_of_type_Nda;
  
  public ndv(ncz paramncz)
  {
    this.jdField_a_of_type_Ncz = paramncz;
  }
  
  public String a(Context paramContext, mze parammze)
  {
    paramContext = "";
    Object localObject = parammze.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690279);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = parammze.c();
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
      paramContext = ((mzj)localObject).m;
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
    return paramContext.getResources().getString(2131690278);
  }
  
  public nda a()
  {
    return this.jdField_a_of_type_Nda;
  }
  
  public void a(myp parammyp)
  {
    this.jdField_a_of_type_Ncz.a(parammyp);
  }
  
  public void a(mze parammze)
  {
    a(myk.a(parammze), false);
    this.jdField_a_of_type_Nda.a().d(false);
  }
  
  public void a(nda paramnda)
  {
    this.jdField_a_of_type_Nda = paramnda;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ncz.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Ncz.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(mze parammze)
  {
    myp localmyp = parammze.a();
    a(myk.a(parammze), true);
    a(localmyp);
    this.jdField_a_of_type_Nda.a().d(true);
    this.jdField_a_of_type_Nda.a().a(parammze.a().a.c * 1000, parammze.a().e());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    if (localmyp != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmyp.b(), Boolean.valueOf(false)));
    }
  }
  
  public void c(mze parammze)
  {
    myp localmyp = parammze.a();
    a(myk.a(parammze), true);
    a(localmyp);
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    this.jdField_a_of_type_Nda.a().a(parammze.a().a.c * 1000, parammze.a().e());
    if (localmyp != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmyp.b(), Boolean.valueOf(false)));
    }
  }
  
  public void d(mze parammze)
  {
    parammze = parammze.a();
    if ((parammze != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      parammze = parammze.b();
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parammze, Boolean.valueOf(true)));
      QLog.d("GuessPictureStagePresenter", 2, "onAnswerRight " + parammze);
    }
  }
  
  public void e(mze parammze) {}
  
  public void f(mze parammze)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      parammze = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (!((Boolean)((Pair)localObject2).second).booleanValue()) {
          parammze.add(((Pair)localObject2).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver all:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " notAnswer:" + parammze.size());
      }
      localObject1 = new Random();
      if (parammze.isEmpty())
      {
        i = ((Random)localObject1).nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label362;
        }
        parammze = (String)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i)).first;
      }
    }
    for (;;)
    {
      localObject2 = a().a().b();
      localObject1 = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(parammze)) {
          ((JSONObject)localObject1).putOpt("textContent", parammze);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).putOpt("bgUrl", localObject2);
        }
      }
      catch (JSONException parammze)
      {
        for (;;)
        {
          QLog.d("GuessPictureStagePresenter", 2, parammze, new Object[0]);
        }
      }
      parammze = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver str:" + parammze);
      }
      myk.a().a().a(parammze);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      if (parammze.size() == 1)
      {
        parammze = (String)parammze.get(0);
      }
      else
      {
        i = ((Random)localObject1).nextInt(parammze.size());
        if (i < parammze.size()) {
          parammze = (String)parammze.get(i);
        } else {
          label362:
          parammze = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndv
 * JD-Core Version:    0.7.0.1
 */