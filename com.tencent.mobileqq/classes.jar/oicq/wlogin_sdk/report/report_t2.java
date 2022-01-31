package oicq.wlogin_sdk.report;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

public class report_t2
  extends report_t
{
  private static final long serialVersionUID = 1L;
  public long _app = 0L;
  public long[] _app_list = null;
  public TreeMap<Integer, report_t3> _log = new TreeMap();
  public String _name = new String("");
  public String _oper = new String("");
  public int _rlen = 0;
  public int _rst1 = 0;
  public int _rst2 = 0;
  public int _slen = 0;
  public long _start = 0L;
  public long _sub_app = 0L;
  public String _type = new String("");
  public long _uin = 0L;
  public int _used = 0;
  public int attr;
  
  public report_t2(int paramInt)
  {
    this._type = "login";
    this._oper = "null";
    this._start = System.currentTimeMillis();
    this._app = 0L;
    this._sub_app = 0L;
    this._app_list = null;
    this.attr = paramInt;
  }
  
  public report_t2(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong)
  {
    this._type = paramString1;
    this._oper = paramString2;
    this._start = paramLong1;
    this._app = paramLong2;
    this._sub_app = paramLong3;
    this._app_list = paramArrayOfLong;
  }
  
  public void add_t3(report_t3 paramreport_t3)
  {
    this._rlen += paramreport_t3._rlen;
    this._slen += paramreport_t3._slen;
    this._log.put(Integer.valueOf(this._log.size()), paramreport_t3);
  }
  
  public void clear_t3()
  {
    this._log.clear();
  }
  
  public void commit(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this._uin = paramLong;
    this._name = paramString;
    this._rst1 = paramInt1;
    this._rst2 = paramInt2;
    this._used = ((int)(System.currentTimeMillis() - this._start));
  }
  
  public JSONObject toJasonObj()
  {
    try
    {
      localObject3 = new JSONObject();
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label231:
      localObject1 = null;
      label345:
      label497:
      localObject3 = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject3, true);
      localException1.printStackTrace(localPrintWriter);
      localPrintWriter.flush();
      ((StringWriter)localObject3).flush();
      util.LOGD("exception", ((StringWriter)localObject3).toString());
      return localObject1;
    }
    try
    {
      ((JSONObject)localObject3).put("type", this._type);
      ((JSONObject)localObject3).put("oper", this._oper);
      ((JSONObject)localObject3).put("start", String.format("%d", new Object[] { Long.valueOf(this._start / 1000L & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("used", String.format("%d", new Object[] { Long.valueOf(this._used & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("uin", String.format("%d", new Object[] { Long.valueOf(this._uin & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("app", String.format("%d", new Object[] { Long.valueOf(this._app & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("subapp", String.format("%d", new Object[] { Long.valueOf(this._sub_app & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("email", this._name);
      ((JSONObject)localObject3).put("attr", this.attr);
      localObject1 = "";
      localObject2 = localObject1;
      if (this._app_list == null) {
        break label345;
      }
      i = 0;
    }
    catch (Exception localException2)
    {
      localObject1 = localObject3;
      break label497;
      i += 1;
      break label231;
    }
    localObject2 = localObject1;
    if (i < this._app_list.length)
    {
      if (i == this._app_list.length - 1) {
        localObject1 = (String)localObject1 + String.format("%d", new Object[] { Long.valueOf(this._app_list[i] & 0xFFFFFFFF) });
      } else {
        localObject1 = (String)localObject1 + String.format("%d,", new Object[] { Long.valueOf(this._app_list[i] & 0xFFFFFFFF) });
      }
    }
    else
    {
      ((JSONObject)localObject3).put("applist", localObject2);
      ((JSONObject)localObject3).put("rst1", String.format("%d", new Object[] { Long.valueOf(this._rst1 & 0xFFFFFFFF) }));
      ((JSONObject)localObject3).put("rst2", String.format("%d", new Object[] { Long.valueOf(this._rst2 & 0xFFFFFFFF) }));
      localObject1 = new JSONArray();
      localObject2 = this._log.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((JSONArray)localObject1).put(i, ((report_t3)this._log.get(((Iterator)localObject2).next())).toJasonObj());
        i += 1;
      }
      ((JSONObject)localObject3).put("log", localObject1);
      return localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.report_t2
 * JD-Core Version:    0.7.0.1
 */