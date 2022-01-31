package com.tencent.plato.bridge;

import org.json.JSONArray;

public abstract interface IScriptExecutor
{
  public abstract void close();
  
  public abstract String executeJSCall(String paramString, JSONArray paramJSONArray)
    throws ScriptException;
  
  public abstract void loadApplicationScript(String paramString)
    throws ScriptException;
  
  public abstract void setGlobalVariable(String paramString1, String paramString2);
  
  public static abstract interface Factory
  {
    public abstract IScriptExecutor create()
      throws Exception;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.bridge.IScriptExecutor
 * JD-Core Version:    0.7.0.1
 */