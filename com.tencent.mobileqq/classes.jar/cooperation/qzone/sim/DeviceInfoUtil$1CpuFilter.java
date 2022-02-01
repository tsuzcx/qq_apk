package cooperation.qzone.sim;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class DeviceInfoUtil$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.sim.DeviceInfoUtil.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */