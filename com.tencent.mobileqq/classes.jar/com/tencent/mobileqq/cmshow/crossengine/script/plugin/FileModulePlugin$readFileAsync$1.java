package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FileModulePlugin$readFileAsync$1
  implements Runnable
{
  FileModulePlugin$readFileAsync$1(FileModulePlugin paramFileModulePlugin, CEArgument paramCEArgument) {}
  
  public final void run()
  {
    JSONObject localJSONObject = FileModulePlugin.a(this.this$0, this.a);
    this.a.a(localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FileModulePlugin.readFileAsync.1
 * JD-Core Version:    0.7.0.1
 */