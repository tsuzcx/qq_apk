import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;

public class mjm
  extends AsyncTask<ArrayList<mjq>, mjq, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new mjp(null);
  private String jdField_a_of_type_JavaLangString = mjm.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mjq parammjq, mjr parammjr)
  {
    try
    {
      localObject = new HttpGet(parammjq.jdField_a_of_type_JavaLangString);
      parammjr = (mjr)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammjr.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammjr = null;
        continue;
        parammjr.setHeader("Net-type", "gprs");
      }
    }
    if (parammjr != null) {
      if (badq.h(BaseApplication.getContext()))
      {
        parammjr.setHeader("Net-type", "Wifi");
        if (parammjq.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammjr;
        }
        parammjq = parammjq.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammjq.hasNext())
        {
          localObject = (Map.Entry)parammjq.next();
          parammjr.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammjr;
  }
  
  private boolean a(mjr parammjr, HttpEntity paramHttpEntity, int paramInt)
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
          parammjr.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammjr.jdField_a_of_type_Long = paramInt;
          parammjr.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammjr.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammjr.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
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
            parammjr.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammjr.jdField_a_of_type_JavaLangString = localIOException.toString();
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
          parammjr.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammjr.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammjr.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mjq>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mjq localmjq;
    while (localIterator.hasNext())
    {
      localmjq = (mjq)localIterator.next();
      localmjq.jdField_a_of_type_Mjr = new mjr();
      localmjq.jdField_a_of_type_Mjr.jdField_a_of_type_Int = -1;
    }
    if (ea.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = ea.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localmjq = (mjq)localIterator.next();
        k = m;
        if (localmjq.jdField_b_of_type_Int != m)
        {
          k = localmjq.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmjq.c != i)
        {
          m = localmjq.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmjq.jdField_a_of_type_Int;
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
      localmjq.jdField_a_of_type_Mjr.jdField_b_of_type_Long = (l2 - l1);
      localmjq.jdField_a_of_type_Mjr.jdField_b_of_type_Int = (localmjq.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmjq.toString() + ", ";
      b(localmjq);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mjo(this, new mjq[] { localmjq })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmjq));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = badq.g(BaseApplication.getContext());
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
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  public void a(mjq parammjq) {}
  
  protected boolean a(HttpClient paramHttpClient, mjq parammjq)
  {
    mjr localmjr = parammjq.jdField_a_of_type_Mjr;
    localmjr.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammjq, localmjr);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmjr.jdField_a_of_type_Boolean;
      parammjq = null;
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
          paramHttpClient = parammjq;
          if (localIOException != null)
          {
            localmjr.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammjq;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammjq;
          if (localException != null)
          {
            localmjr.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammjq;
          }
        }
        parammjq = paramHttpClient.getEntity();
        if (parammjq == null)
        {
          localmjr.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammjq.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmjr.jdField_a_of_type_Int = 2;
              localmjr.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmjr.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammjq.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmjr.jdField_a_of_type_Boolean = a(localmjr, parammjq, j);
            break label192;
            localmjr.jdField_a_of_type_Int = 2;
            localmjr.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mjq parammjq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjm
 * JD-Core Version:    0.7.0.1
 */