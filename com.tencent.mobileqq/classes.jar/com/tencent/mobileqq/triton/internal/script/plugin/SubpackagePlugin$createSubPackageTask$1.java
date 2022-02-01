package com.tencent.mobileqq.triton.internal.script.plugin;

import com.tencent.mobileqq.triton.script.Argument;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "totalBytes", "", "currentBytes", "invoke"}, k=3, mv={1, 1, 16})
final class SubpackagePlugin$createSubPackageTask$1
  extends Lambda
  implements Function2<Long, Long, Unit>
{
  SubpackagePlugin$createSubPackageTask$1(int paramInt, Argument paramArgument)
  {
    super(2);
  }
  
  public final void invoke(long paramLong1, long paramLong2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("taskId", this.$taskId);
    localJSONObject.put("state", "progressUpdate");
    localJSONObject.put("progress", paramLong2 / RangesKt.coerceAtLeast(paramLong1, 1L));
    localJSONObject.put("totalBytesWritten", paramLong2);
    localJSONObject.put("totalBytesExpectedToWrite", paramLong1);
    this.$arguments.subscribe("onLoadSubPackageTaskStateChange", localJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin.createSubPackageTask.1
 * JD-Core Version:    0.7.0.1
 */