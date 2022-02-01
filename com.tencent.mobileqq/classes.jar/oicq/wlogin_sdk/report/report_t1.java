package oicq.wlogin_sdk.report;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.LogCallBack;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

public class report_t1
  extends report_t
{
  private static final long serialVersionUID = 1L;
  public String _app_n = new String("");
  public String _app_sig = new String("");
  public String _app_v = new String("");
  public String _btime = util.get_release_time();
  public String _bver = "6.0.0.2473";
  public String _device = new String("");
  public String _disp_name = new String("");
  public String _ksid = new String("");
  public TreeMap<Integer, report_t2> _lst = new TreeMap();
  public int _os = 2;
  public String _os_v = new String("");
  public String _sdk_v = new Integer(17).toString();
  
  public void add_t2(report_t2 paramreport_t2)
  {
    try
    {
      if (this._lst.size() >= 10) {
        this._lst.remove(Integer.valueOf(this._lst.size() - 1));
      }
      this._lst.put(Integer.valueOf(this._lst.size()), paramreport_t2);
      return;
    }
    finally {}
  }
  
  public void add_t3(report_t3 paramreport_t3)
  {
    try
    {
      int i = this._lst.size();
      if (i <= 0) {
        return;
      }
      ((report_t2)this._lst.get(Integer.valueOf(this._lst.size() - 1))).add_t3(paramreport_t3);
      return;
    }
    finally {}
  }
  
  public void attr_api(int paramInt)
  {
    try
    {
      add_t2(new report_t2(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clear_t2()
  {
    try
    {
      Iterator localIterator = this._lst.keySet().iterator();
      while (localIterator.hasNext()) {
        ((report_t2)this._lst.get(localIterator.next())).clear_t3();
      }
      this._lst.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void commit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    try
    {
      this._os_v = paramString1;
      this._app_v = paramString2;
      this._ksid = paramString4;
      this._app_n = paramString5;
      this._disp_name = paramString6;
      this._device = paramString7;
      this._app_sig = paramString8;
      this._btime = paramString9;
      this._bver = paramString10;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void commit_t2(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      int i = this._lst.size();
      if (i <= 0) {
        return;
      }
      ((report_t2)this._lst.get(Integer.valueOf(this._lst.size() - 1))).commit(paramLong, paramString, paramInt1, paramInt2);
      if (util.LCB != null) {
        util.LCB.OnLog(((report_t2)this._lst.get(Integer.valueOf(this._lst.size() - 1))).toJasonObj());
      }
      return;
    }
    finally {}
  }
  
  public JSONObject toJasonObj()
  {
    try
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        int j;
        int i;
        JSONArray localJSONArray;
        Iterator localIterator;
        localJSONObject2 = null;
      }
      finally
      {
        try
        {
          j = this._os;
          i = 0;
          localJSONObject1.put("os", String.format("%d", new Object[] { Integer.valueOf(j) }));
          localJSONObject1.put("os_v", this._os_v);
          localJSONObject1.put("app_v", this._app_v);
          localJSONObject1.put("sdk_v", this._sdk_v);
          localJSONObject1.put("ksid", this._ksid);
          localJSONObject1.put("app_n", this._app_n);
          localJSONObject1.put("disp_name", this._disp_name);
          localJSONObject1.put("device", this._device);
          localJSONObject1.put("app_sig", this._app_sig);
          localJSONObject1.put("btime", this._btime);
          localJSONObject1.put("bver", this._bver);
          localJSONArray = new JSONArray();
          localIterator = this._lst.keySet().iterator();
          while (localIterator.hasNext())
          {
            localJSONArray.put(i, ((report_t2)this._lst.get(localIterator.next())).toJasonObj());
            i += 1;
          }
          localJSONObject1.put("lst", localJSONArray);
        }
        catch (Exception localException2)
        {
          JSONObject localJSONObject2;
          break label236;
        }
        localObject = finally;
      }
    }
    catch (Exception localException1)
    {
      label234:
      label236:
      break label234;
    }
    return localJSONObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t1
 * JD-Core Version:    0.7.0.1
 */