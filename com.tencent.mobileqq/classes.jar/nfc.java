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

public class nfc
  implements ned
{
  private ArrayList<Pair<String, Boolean>> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  nee jdField_a_of_type_Nee;
  neg jdField_a_of_type_Neg;
  
  public nfc(nee paramnee)
  {
    this.jdField_a_of_type_Nee = paramnee;
  }
  
  public String a(Context paramContext, naf paramnaf)
  {
    paramContext = "";
    Object localObject = paramnaf.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690304);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramnaf.c();
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
      paramContext = ((nak)localObject).m;
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
    return paramContext.getResources().getString(2131690303);
  }
  
  public neg a()
  {
    return this.jdField_a_of_type_Neg;
  }
  
  public void a(mzq parammzq)
  {
    this.jdField_a_of_type_Nee.a(parammzq);
  }
  
  public void a(naf paramnaf)
  {
    a(mzl.a(paramnaf), false);
    this.jdField_a_of_type_Neg.a().d(false);
  }
  
  public void a(neg paramneg)
  {
    this.jdField_a_of_type_Neg = paramneg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nee.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nee.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(naf paramnaf)
  {
    mzq localmzq = paramnaf.a();
    a(mzl.a(paramnaf), true);
    a(localmzq);
    this.jdField_a_of_type_Neg.a().d(true);
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().a.c * 1000, paramnaf.a().e());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().f(), paramnaf.a().d());
    if (localmzq != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmzq.b(), Boolean.valueOf(false)));
    }
  }
  
  public void c(naf paramnaf)
  {
    mzq localmzq = paramnaf.a();
    a(mzl.a(paramnaf), true);
    a(localmzq);
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().f(), paramnaf.a().d());
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().a.c * 1000, paramnaf.a().e());
    if (localmzq != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmzq.b(), Boolean.valueOf(false)));
    }
  }
  
  public void d(naf paramnaf)
  {
    paramnaf = paramnaf.a();
    if ((paramnaf != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramnaf = paramnaf.b();
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramnaf, Boolean.valueOf(true)));
      QLog.d("GuessPictureStagePresenter", 2, "onAnswerRight " + paramnaf);
    }
  }
  
  public void e(naf paramnaf) {}
  
  public void f(naf paramnaf)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      paramnaf = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (!((Boolean)((Pair)localObject2).second).booleanValue()) {
          paramnaf.add(((Pair)localObject2).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver all:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " notAnswer:" + paramnaf.size());
      }
      localObject1 = new Random();
      if (paramnaf.isEmpty())
      {
        i = ((Random)localObject1).nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label362;
        }
        paramnaf = (String)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i)).first;
      }
    }
    for (;;)
    {
      localObject2 = a().a().b();
      localObject1 = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(paramnaf)) {
          ((JSONObject)localObject1).putOpt("textContent", paramnaf);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).putOpt("bgUrl", localObject2);
        }
      }
      catch (JSONException paramnaf)
      {
        for (;;)
        {
          QLog.d("GuessPictureStagePresenter", 2, paramnaf, new Object[0]);
        }
      }
      paramnaf = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver str:" + paramnaf);
      }
      mzl.a().a().a(paramnaf);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      if (paramnaf.size() == 1)
      {
        paramnaf = (String)paramnaf.get(0);
      }
      else
      {
        i = ((Random)localObject1).nextInt(paramnaf.size());
        if (i < paramnaf.size()) {
          paramnaf = (String)paramnaf.get(i);
        } else {
          label362:
          paramnaf = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */