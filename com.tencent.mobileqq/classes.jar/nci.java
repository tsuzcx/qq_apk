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

public class nci
  implements nbl
{
  private ArrayList<Pair<String, Boolean>> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  nbm jdField_a_of_type_Nbm;
  nbn jdField_a_of_type_Nbn;
  
  public nci(nbm paramnbm)
  {
    this.jdField_a_of_type_Nbm = paramnbm;
  }
  
  public String a(Context paramContext, myc parammyc)
  {
    paramContext = "";
    Object localObject = parammyc.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690274);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = parammyc.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label108;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      return paramContext + (String)localObject;
      paramContext = ((myg)localObject).l;
      break;
      label108:
      QLog.e("GuessPictureStagePresenter", 1, "textTypeString tips isEmpty");
    }
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
    return paramContext.getResources().getString(2131690273);
  }
  
  public nbn a()
  {
    return this.jdField_a_of_type_Nbn;
  }
  
  public void a(mxq parammxq)
  {
    this.jdField_a_of_type_Nbm.a(parammxq);
  }
  
  public void a(myc parammyc)
  {
    a(mxl.a(parammyc), false);
    this.jdField_a_of_type_Nbn.a().d(false);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbn = paramnbn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nbm.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nbm.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(myc parammyc)
  {
    mxq localmxq = parammyc.a();
    a(mxl.a(parammyc), true);
    a(localmxq);
    this.jdField_a_of_type_Nbn.a().d(true);
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().a.c * 1000, parammyc.a().e());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    if (localmxq != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmxq.b(), Boolean.valueOf(false)));
    }
  }
  
  public void c(myc parammyc)
  {
    mxq localmxq = parammyc.a();
    a(mxl.a(parammyc), true);
    a(localmxq);
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().a.c * 1000, parammyc.a().e());
    if (localmxq != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localmxq.b(), Boolean.valueOf(false)));
    }
  }
  
  public void d(myc parammyc)
  {
    parammyc = parammyc.a();
    if ((parammyc != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      parammyc = parammyc.b();
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parammyc, Boolean.valueOf(true)));
      QLog.d("GuessPictureStagePresenter", 2, "onAnswerRight " + parammyc);
    }
  }
  
  public void e(myc parammyc) {}
  
  public void f(myc parammyc)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      parammyc = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (!((Boolean)((Pair)localObject2).second).booleanValue()) {
          parammyc.add(((Pair)localObject2).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver all:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " notAnswer:" + parammyc.size());
      }
      localObject1 = new Random();
      if (parammyc.isEmpty())
      {
        i = ((Random)localObject1).nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label362;
        }
        parammyc = (String)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i)).first;
      }
    }
    for (;;)
    {
      localObject2 = a().a().b();
      localObject1 = new JSONObject();
      try
      {
        if (!TextUtils.isEmpty(parammyc)) {
          ((JSONObject)localObject1).putOpt("textContent", parammyc);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).putOpt("bgUrl", localObject2);
        }
      }
      catch (JSONException parammyc)
      {
        for (;;)
        {
          QLog.d("GuessPictureStagePresenter", 2, parammyc, new Object[0]);
        }
      }
      parammyc = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "onGameOver str:" + parammyc);
      }
      mxl.a().a().a(parammyc);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      if (parammyc.size() == 1)
      {
        parammyc = (String)parammyc.get(0);
      }
      else
      {
        i = ((Random)localObject1).nextInt(parammyc.size());
        if (i < parammyc.size()) {
          parammyc = (String)parammyc.get(i);
        } else {
          label362:
          parammyc = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nci
 * JD-Core Version:    0.7.0.1
 */