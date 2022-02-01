import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.download.BaseDownloadAsyncTask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;

public class mvj
  extends AsyncTask<ArrayList<mvm>, mvm, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new mvl(null);
  private String jdField_a_of_type_JavaLangString = mvj.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mvm parammvm, mvn parammvn)
  {
    try
    {
      localObject = new HttpGet(parammvm.jdField_a_of_type_JavaLangString);
      parammvn = (mvn)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammvn.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammvn = null;
        continue;
        parammvn.setHeader("Net-type", "gprs");
      }
    }
    if (parammvn != null) {
      if (bhnv.h(BaseApplication.getContext()))
      {
        parammvn.setHeader("Net-type", "Wifi");
        if (parammvm.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammvn;
        }
        parammvm = parammvm.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammvm.hasNext())
        {
          localObject = (Map.Entry)parammvm.next();
          parammvn.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammvn;
  }
  
  private boolean a(mvn parammvn, HttpEntity paramHttpEntity, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    try
    {
      paramHttpEntity = paramHttpEntity.getContent();
      if (paramHttpEntity == null)
      {
        i = 0;
        if (paramHttpEntity == null) {}
      }
    }
    catch (IOException paramHttpEntity)
    {
      try
      {
        for (;;)
        {
          paramHttpEntity.close();
          if (i != paramInt) {
            break;
          }
          bool = true;
          if (!bool) {
            break label235;
          }
          parammvn.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammvn.jdField_a_of_type_Long = paramInt;
          parammvn.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammvn.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammvn.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
          }
          paramHttpEntity = null;
        }
        byte[] arrayOfByte2 = new byte[2048];
        i = 0;
        for (;;)
        {
          try
          {
            j = paramHttpEntity.read(arrayOfByte2);
            if (j > 0) {}
          }
          catch (IOException localIOException)
          {
            parammvn.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammvn.jdField_a_of_type_JavaLangString = localIOException.toString();
            }
            int j = 0;
            continue;
            if (i + j > paramInt)
            {
              i += j;
              break;
            }
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
            i += j;
          }
        }
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          int i;
          paramHttpEntity.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label235:
          parammvn.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammvn.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammvn.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mvm>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mvm localmvm;
    while (localIterator.hasNext())
    {
      localmvm = (mvm)localIterator.next();
      localmvm.jdField_a_of_type_Mvn = new mvn();
      localmvm.jdField_a_of_type_Mvn.jdField_a_of_type_Int = -1;
    }
    if (eh.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = eh.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localmvm = (mvm)localIterator.next();
        k = m;
        if (localmvm.jdField_b_of_type_Int != m)
        {
          k = localmvm.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmvm.c != i)
        {
          m = localmvm.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmvm.jdField_a_of_type_Int;
        if (!isCancelled()) {
          break;
        }
      }
      if ((QLog.isColorLevel()) && (!paramVarArgs.equals(""))) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramVarArgs);
      }
      return Integer.valueOf(j);
    }
    long l1 = System.currentTimeMillis();
    if (isCancelled()) {
      n = i;
    }
    label272:
    do
    {
      j += 1;
      long l2 = System.currentTimeMillis();
      localmvm.jdField_a_of_type_Mvn.jdField_b_of_type_Long = (l2 - l1);
      localmvm.jdField_a_of_type_Mvn.jdField_b_of_type_Int = (localmvm.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmvm.toString() + ", ";
      b(localmvm);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mvk(this, new mvm[] { localmvm })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmvm));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = bhnv.g(BaseApplication.getContext());
          if (!bool) {
            break label452;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        i = n;
      }
      n = i - 1;
      if (i <= 0) {
        break label272;
      }
      break;
      label452:
      n -= 1;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null)
    {
      ThreadManager.excute(new BaseDownloadAsyncTask.1(this, this.jdField_a_of_type_OrgApacheHttpClientHttpClient), 16, null, false);
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  public void a(mvm parammvm) {}
  
  protected boolean a(HttpClient paramHttpClient, mvm parammvm)
  {
    mvn localmvn = parammvm.jdField_a_of_type_Mvn;
    localmvn.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammvm, localmvn);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmvn.jdField_a_of_type_Boolean;
      parammvm = null;
      try
      {
        paramHttpClient = paramHttpClient.execute(localHttpGet);
        if (paramHttpClient == null) {
          return false;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramHttpClient = parammvm;
          if (localIOException != null)
          {
            localmvn.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammvm;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammvm;
          if (localException != null)
          {
            localmvn.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammvm;
          }
        }
        parammvm = paramHttpClient.getEntity();
        if (parammvm == null)
        {
          localmvn.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammvm.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmvn.jdField_a_of_type_Int = 2;
              localmvn.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmvn.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammvm.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmvn.jdField_a_of_type_Boolean = a(localmvn, parammvm, j);
            break label192;
            localmvn.jdField_a_of_type_Int = 2;
            localmvn.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mvm parammvm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvj
 * JD-Core Version:    0.7.0.1
 */