import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nfr
{
  protected Context a;
  protected View.OnClickListener a;
  protected bfpc a;
  String a;
  protected ArrayList<nmv> a;
  protected nfb a;
  String b;
  
  public nfr(Context paramContext, ArrayList<nmv> paramArrayList, nfb paramnfb, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nfs(this);
    this.jdField_a_of_type_Bfpc = new nft(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nfb = paramnfb;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public static ArrayList<nmv> a(nmu paramnmu, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnmu != null) && (paramnmu.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnmu.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nmv localnmv = (nmv)localIterator.next();
        if ((localnmv.jdField_b_of_type_Int == 0) || ((localnmv.jdField_b_of_type_Int == 1) && (paramInt == 1))) {}
        for (int i = 1; i != 0; i = 0) {
          switch (paramnmu.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 2: 
            if (localnmv.jdField_c_of_type_Int != 23) {
              break label162;
            }
            if ((TextUtils.isEmpty(localnmv.e)) || (TextUtils.isEmpty(localnmv.jdField_b_of_type_JavaLangString))) {
              break;
            }
            localArrayList.add(localnmv);
            break;
          }
        }
        label162:
        if (!TextUtils.isEmpty(localnmv.e))
        {
          localArrayList.add(localnmv);
          continue;
          if (localnmv.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localnmv.e)) && (!TextUtils.isEmpty(localnmv.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnmv.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localnmv);
            }
          }
          else if ((!TextUtils.isEmpty(localnmv.e)) && (!TextUtils.isEmpty(localnmv.jdField_a_of_type_JavaLangString))) {
            localArrayList.add(localnmv);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(nmv paramnmv)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = (akdi)((QQAppInterface)localObject1).getManager(56);
        if (localObject2 != null)
        {
          localObject2 = ((akdi)localObject2).a(this.jdField_a_of_type_JavaLangString);
          if ((localObject2 == null) || (((AccountDetail)localObject2).followType != 1)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AccountDetailActivity))) {}
        for (int j = noo.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, null);; j = 1)
        {
          if ((paramnmv.jdField_a_of_type_Int == 3) && (paramnmv.jdField_c_of_type_Int == 23))
          {
            paramnmv = paramnmv.jdField_b_of_type_JavaLangString;
            localObject1 = new nex();
            ((nex)localObject1).a(paramnmv);
            localObject1 = ((nex)localObject1).a.jdField_c_of_type_JavaLangString;
            localObject2 = this.jdField_a_of_type_JavaLangString;
            if (i != 0)
            {
              paramnmv = "02";
              noo.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "2", (String)localObject1, paramnmv, String.valueOf(j), false);
            }
          }
          while (paramnmv.jdField_a_of_type_Int != 1) {
            for (;;)
            {
              return;
              paramnmv = "01";
            }
          }
          paramnmv = Uri.parse(paramnmv.jdField_c_of_type_JavaLangString);
          try
          {
            paramnmv = paramnmv.getQueryParameter("article_id");
            if (TextUtils.isEmpty(paramnmv))
            {
              paramnmv = "";
              localObject2 = this.jdField_a_of_type_JavaLangString;
              if (i != 0)
              {
                localObject1 = "02";
                noo.a(null, (String)localObject2, "0X80077F9", "0X80077F9", 0, 0, "1", paramnmv, (String)localObject1, String.valueOf(j), false);
                return;
              }
            }
          }
          catch (Exception paramnmv)
          {
            for (;;)
            {
              paramnmv.printStackTrace();
              paramnmv = null;
              continue;
              localObject1 = "01";
            }
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<nmv> paramArrayList)
  {
    if (paramArrayList.size() != this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label49;
      }
      if (paramArrayList.get(i) != this.jdField_a_of_type_JavaUtilArrayList.get(i)) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfr
 * JD-Core Version:    0.7.0.1
 */